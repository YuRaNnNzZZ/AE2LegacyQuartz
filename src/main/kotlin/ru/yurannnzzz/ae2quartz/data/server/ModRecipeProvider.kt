package ru.yurannnzzz.ae2quartz.data.server

import appeng.core.definitions.AEItems
import appeng.datagen.providers.tags.ConventionTags
import appeng.recipes.handlers.InscriberProcessType
import appeng.recipes.handlers.InscriberRecipeBuilder
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder
import net.minecraft.world.item.crafting.Ingredient
import ru.yurannnzzz.ae2quartz.AE2QuartzMod.loc
import ru.yurannnzzz.ae2quartz.registry.ModItems
import java.util.concurrent.CompletableFuture

class ModRecipeProvider(output: PackOutput, provider: CompletableFuture<HolderLookup.Provider>) : RecipeProvider(output, provider) {
	override fun buildRecipes(recipeOutput: RecipeOutput) {
		InscriberRecipeBuilder
			.inscribe(ConventionTags.ALL_NETHER_QUARTZ, ModItems.NETHER_QUARTZ_DUST.get(), 1)
			.setMode(InscriberProcessType.INSCRIBE)
			.save(recipeOutput, loc("inscriber/nether_quartz_dust"))

		SimpleCookingRecipeBuilder
			.smelting(Ingredient.of(ModTags.NETHER_QUARTZ_DUST), RecipeCategory.MISC, AEItems.SILICON, .35f, 200)
			.unlockedBy("has_nether_quartz_dust", has(ModTags.NETHER_QUARTZ_DUST))
			.save(recipeOutput, loc("smelting/silicon_from_nether_quartz_dust"))
		SimpleCookingRecipeBuilder
			.blasting(Ingredient.of(ModTags.NETHER_QUARTZ_DUST), RecipeCategory.MISC, AEItems.SILICON, .35f, 100)
			.unlockedBy("has_nether_quartz_dust", has(ModTags.NETHER_QUARTZ_DUST))
			.save(recipeOutput, loc("blasting/silicon_from_nether_quartz_dust"))
	}
}
