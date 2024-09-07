package ru.yurannnzzz.ae2quartz.data.server

import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BiomeTags
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.levelgen.GenerationStep
import net.minecraft.world.level.levelgen.VerticalAnchor
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration
import net.minecraft.world.level.levelgen.placement.CountPlacement
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement
import net.minecraft.world.level.levelgen.placement.InSquarePlacement
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest
import net.neoforged.neoforge.common.world.BiomeModifier
import net.neoforged.neoforge.registries.NeoForgeRegistries
import ru.yurannnzzz.ae2quartz.AE2QuartzMod.loc
import ru.yurannnzzz.ae2quartz.registry.ModBlocks

/*
 * straight up copy and edit of OTM tritanium worldgen
 * author: DBotThePony
 */

private object ConfiguredFeatures {
	val QUARTZ_ORE = key("quartz_ore")

	private fun key(name: String): ResourceKey<ConfiguredFeature<*, *>> {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, loc(name))
	}
}

fun registerConfiguredFeatures(context: BootstrapContext<ConfiguredFeature<*, *>>) {
	val target = listOf(
		OreConfiguration.target(
			TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
			ModBlocks.QUARTZ_ORE.get().defaultBlockState()
		),
		OreConfiguration.target(
			TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
			ModBlocks.DEEPSLATE_QUARTZ_ORE.get().defaultBlockState()
		),
	)

	context.register(
		ConfiguredFeatures.QUARTZ_ORE,
		ConfiguredFeature(Feature.ORE, OreConfiguration(target, 7))
	)
}

private object PlacedFeatures {
	val QUARTZ_ORE = key("quartz_ore")

	private fun key(name: String): ResourceKey<PlacedFeature> {
		return ResourceKey.create(Registries.PLACED_FEATURE, loc(name))
	}
}

fun registerPlacedFeatures(context: BootstrapContext<PlacedFeature>) {
	val configured = context.lookup(Registries.CONFIGURED_FEATURE)

	context.register(
		PlacedFeatures.QUARTZ_ORE, PlacedFeature(
			configured.getOrThrow(ConfiguredFeatures.QUARTZ_ORE),
			listOf(
				CountPlacement.of(20),
				InSquarePlacement.spread(),
				HeightRangePlacement.triangle(VerticalAnchor.absolute(-34), VerticalAnchor.absolute(36))
			)
		)
	)
}

private object BiomeModifiers {
	val QUARTZ_ORE = key("quartz_ore")

	private fun key(name: String): ResourceKey<BiomeModifier> {
		return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, loc(name))
	}
}

fun registerBiomeModifiers(context: BootstrapContext<BiomeModifier>) {
	val placed = context.lookup(Registries.PLACED_FEATURE)
	val biomes = context.lookup(Registries.BIOME)

	context.register(
		BiomeModifiers.QUARTZ_ORE,
		net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier(
			biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
			HolderSet.direct(placed.getOrThrow(PlacedFeatures.QUARTZ_ORE)),
			GenerationStep.Decoration.UNDERGROUND_ORES
		)
	)
}
