package ru.yurannnzzz.ae2quartz.data.server

import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.tags.BlockTags
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.common.data.BlockTagsProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import ru.yurannnzzz.ae2quartz.registry.ModBlocks
import java.util.concurrent.CompletableFuture

class ModBlockTagsProvider(
	output: PackOutput?,
	lookupProvider: CompletableFuture<HolderLookup.Provider?>?,
	modId: String?,
	existingFileHelper: ExistingFileHelper?
) : BlockTagsProvider(output, lookupProvider, modId, existingFileHelper) {
	override fun addTags(provider: HolderLookup.Provider) {
		tag(ModTags.CERTUS_QUARTZ_ORE_BLOCK)
			.add(ModBlocks.QUARTZ_ORE.get())
			.add(ModBlocks.DEEPSLATE_QUARTZ_ORE.get())

		tag(Tags.Blocks.ORES)
			.addTag(ModTags.CERTUS_QUARTZ_ORE_BLOCK)

		tag(BlockTags.MINEABLE_WITH_PICKAXE)
			.add(ModBlocks.QUARTZ_ORE.get())
			.add(ModBlocks.DEEPSLATE_QUARTZ_ORE.get())
	}
}
