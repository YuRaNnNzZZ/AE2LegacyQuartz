package ru.yurannnzzz.ae2quartz.data

import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.data.loot.LootTableProvider.SubProviderEntry
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.minecraftforge.common.data.BlockTagsProvider
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.registries.ForgeRegistries
import ru.yurannnzzz.ae2quartz.AE2QuartzMod.MOD_ID
import ru.yurannnzzz.ae2quartz.data.client.English
import ru.yurannnzzz.ae2quartz.data.client.ModBlockStateProvider
import ru.yurannnzzz.ae2quartz.data.client.ModItemModelProvider
import ru.yurannnzzz.ae2quartz.data.client.Russian
import ru.yurannnzzz.ae2quartz.data.server.ModBlockLootProvider
import ru.yurannnzzz.ae2quartz.data.server.ModBlockTagsProvider
import ru.yurannnzzz.ae2quartz.data.server.ModItemTagsProvider
import ru.yurannnzzz.ae2quartz.data.server.ModRecipeProvider
import ru.yurannnzzz.ae2quartz.data.server.registerBiomeModifiers
import ru.yurannnzzz.ae2quartz.data.server.registerConfiguredFeatures
import ru.yurannnzzz.ae2quartz.data.server.registerPlacedFeatures

fun onDataGather(event: GatherDataEvent) {
	val gen = event.generator
	val efh = event.existingFileHelper
	val out = gen.packOutput

	gen.addProvider(event.includeClient(), ModBlockStateProvider(out, MOD_ID, efh))
	gen.addProvider(event.includeClient(), ModItemModelProvider(out, MOD_ID, efh))
	gen.addProvider(event.includeClient(), English(out, MOD_ID))
	gen.addProvider(event.includeClient(), Russian(out, MOD_ID))

	gen.addProvider(
		event.includeServer(),
		ModRecipeProvider(out)
	)
	val blockTagsProvider: BlockTagsProvider = gen.addProvider(
		event.includeServer(),
		ModBlockTagsProvider(out, event.lookupProvider, MOD_ID, efh)
	)
	gen.addProvider(
		event.includeServer(),
		ModItemTagsProvider(out, event.lookupProvider, blockTagsProvider.contentsGetter(), MOD_ID, efh)
	)
	gen.addProvider(
		event.includeServer(),
		LootTableProvider(
			out,
			emptySet<ResourceLocation>(),
			listOf(SubProviderEntry({ ModBlockLootProvider() }, LootContextParamSets.BLOCK))
		)
	)

	val registrySetBuilder = RegistrySetBuilder()
		.add(Registries.CONFIGURED_FEATURE, ::registerConfiguredFeatures)
		.add(Registries.PLACED_FEATURE, ::registerPlacedFeatures)
		.add(ForgeRegistries.Keys.BIOME_MODIFIERS, ::registerBiomeModifiers)
	event.generator.addProvider(
		event.includeServer(),
		DatapackBuiltinEntriesProvider(
			event.generator.packOutput,
			event.lookupProvider,
			registrySetBuilder,
			setOf(MOD_ID)
		)
	)
}
