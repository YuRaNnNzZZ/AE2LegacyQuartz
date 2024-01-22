package ru.yurannnzzz.ae2quartz.data.server

import appeng.datagen.providers.tags.ConventionTags
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.world.level.block.Block
import net.minecraftforge.common.Tags
import net.minecraftforge.common.data.ExistingFileHelper
import ru.yurannnzzz.ae2quartz.registry.ModItems
import java.util.concurrent.CompletableFuture

class ModItemTagsProvider(
	output: PackOutput?,
	lookupProvider: CompletableFuture<HolderLookup.Provider?>?,
	blockTagLookup: CompletableFuture<TagLookup<Block?>?>?,
	modId: String?,
	existingFileHelper: ExistingFileHelper?
) : ItemTagsProvider(output, lookupProvider, blockTagLookup, modId, existingFileHelper) {
	override fun addTags(provider: HolderLookup.Provider) {
		tag(ModTags.CERTUS_QUARTZ_ORE)
			.add(ModItems.QUARTZ_ORE.get())
			.add(ModItems.DEEPSLATE_QUARTZ_ORE.get())

		tag(Tags.Items.ORES)
			.addTag(ModTags.CERTUS_QUARTZ_ORE)

		tag(ModTags.NETHER_QUARTZ_DUST)
			.add(ModItems.NETHER_QUARTZ_DUST.get())

		tag(ConventionTags.ALL_QUARTZ_DUST)
			.addTag(ModTags.NETHER_QUARTZ_DUST)

		tag(Tags.Items.DUSTS)
			.addTag(ModTags.NETHER_QUARTZ_DUST)
	}
}
