package ru.yurannnzzz.ae2quartz.data.client

import net.minecraft.data.PackOutput
import net.minecraftforge.client.model.generators.BlockStateProvider
import net.minecraftforge.client.model.generators.ConfiguredModel
import net.minecraftforge.common.data.ExistingFileHelper
import ru.yurannnzzz.ae2quartz.registry.ModBlocks

class ModBlockStateProvider(output: PackOutput?, modid: String?, exFileHelper: ExistingFileHelper?) :
	BlockStateProvider(output, modid, exFileHelper) {
	override fun registerStatesAndModels() {
		getVariantBuilder(ModBlocks.QUARTZ_ORE.get())
			.partialState()
			.setModels(*Array(4) {
				val loc = modLoc("block/quartz_ore_${it}")

				ConfiguredModel(models().cubeAll(loc.toString(), loc))
			})

		getVariantBuilder(ModBlocks.DEEPSLATE_QUARTZ_ORE.get())
			.partialState()
			.setModels(*Array(4) {
				val loc = modLoc("block/deepslate_quartz_ore_${it}")

				ConfiguredModel(models().cubeAll(loc.toString(), loc))
			})
	}
}
