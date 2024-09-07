package ru.yurannnzzz.ae2quartz.data

import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.data.loot.LootTableProvider.SubProviderEntry
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.neoforged.neoforge.common.data.BlockTagsProvider
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider
import net.neoforged.neoforge.data.event.GatherDataEvent
import net.neoforged.neoforge.registries.NeoForgeRegistries
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

	gen.addProvider(event.includeClient(), ModBlockStateProvider(gen.packOutput, MOD_ID, event.existingFileHelper))
	gen.addProvider(event.includeClient(), ModItemModelProvider(gen.packOutput, MOD_ID, event.existingFileHelper))
	gen.addProvider(event.includeClient(), English(gen.packOutput, MOD_ID))
	gen.addProvider(event.includeClient(), Russian(gen.packOutput, MOD_ID))

	gen.addProvider(
		event.includeServer(),
		ModRecipeProvider(gen.packOutput, event.lookupProvider)
	)
	val blockTagsProvider: BlockTagsProvider = gen.addProvider(
		event.includeServer(),
		ModBlockTagsProvider(gen.packOutput, event.lookupProvider, MOD_ID, event.existingFileHelper)
	)
	gen.addProvider(
		event.includeServer(),
		ModItemTagsProvider(gen.packOutput, event.lookupProvider, blockTagsProvider.contentsGetter(), MOD_ID, event.existingFileHelper)
	)
	gen.addProvider(
		event.includeServer(),
		LootTableProvider(
			gen.packOutput,
			mutableSetOf(),
			listOf(SubProviderEntry({ ModBlockLootProvider(event.lookupProvider) }, LootContextParamSets.BLOCK)),
			event.lookupProvider
		)
	)

	val registrySetBuilder = RegistrySetBuilder()
		.add(Registries.CONFIGURED_FEATURE, ::registerConfiguredFeatures)
		.add(Registries.PLACED_FEATURE, ::registerPlacedFeatures)
		.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ::registerBiomeModifiers)
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
