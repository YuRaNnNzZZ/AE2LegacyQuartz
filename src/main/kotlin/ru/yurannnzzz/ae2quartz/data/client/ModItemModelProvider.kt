package ru.yurannnzzz.ae2quartz.data.client

import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile
import net.minecraftforge.common.data.ExistingFileHelper

class ModItemModelProvider(output: PackOutput?, modid: String?, existingFileHelper: ExistingFileHelper?) :
	ItemModelProvider(output, modid, existingFileHelper) {
	override fun registerModels() {
		val netherQuartzDustTexture = ResourceLocation("ae2", "item/nether_quartz_dust")
		existingFileHelper.trackGenerated(netherQuartzDustTexture, TEXTURE)

		getBuilder(modLoc("item/nether_quartz_dust").toString())
			.parent(UncheckedModelFile("item/generated"))
			.texture("layer0", netherQuartzDustTexture)

		withExistingParent(
			modLoc("item/quartz_ore").toString(),
			modLoc("block/quartz_ore_0")
		)
		withExistingParent(
			modLoc("item/deepslate_quartz_ore").toString(),
			modLoc("block/deepslate_quartz_ore_0")
		)
	}
}
