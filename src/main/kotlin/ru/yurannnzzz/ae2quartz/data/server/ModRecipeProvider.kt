package ru.yurannnzzz.ae2quartz.data.server

import appeng.core.definitions.AEItems
import appeng.datagen.providers.tags.ConventionTags
import appeng.recipes.handlers.InscriberProcessType
import appeng.recipes.handlers.InscriberRecipeBuilder
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.crafting.Ingredient
import ru.yurannnzzz.ae2quartz.AE2QuartzMod
import ru.yurannnzzz.ae2quartz.registry.ModItems
import java.util.function.Consumer

class ModRecipeProvider(output: PackOutput?) : RecipeProvider(output) {
	override fun buildRecipes(consumer: Consumer<FinishedRecipe>) {
		InscriberRecipeBuilder
			.inscribe(ConventionTags.ALL_NETHER_QUARTZ, ModItems.NETHER_QUARTZ_DUST.get(), 1)
			.setMode(InscriberProcessType.INSCRIBE)
			.save(consumer, modLoc("inscriber/nether_quartz_dust"))

		SimpleCookingRecipeBuilder
			.smelting(Ingredient.of(ModTags.NETHER_QUARTZ_DUST), RecipeCategory.MISC, AEItems.SILICON, .35f, 200)
			.unlockedBy("has_nether_quartz_dust", has(ModTags.NETHER_QUARTZ_DUST))
			.save(consumer, modLoc("smelting/silicon_from_nether_quartz_dust"))
		SimpleCookingRecipeBuilder
			.blasting(Ingredient.of(ModTags.NETHER_QUARTZ_DUST), RecipeCategory.MISC, AEItems.SILICON, .35f, 100)
			.unlockedBy("has_nether_quartz_dust", has(ModTags.NETHER_QUARTZ_DUST))
			.save(consumer, modLoc("blasting/silicon_from_nether_quartz_dust"))
	}

	fun modLoc(path: String): ResourceLocation {
		return ResourceLocation(AE2QuartzMod.MOD_ID, path)
	}
}
