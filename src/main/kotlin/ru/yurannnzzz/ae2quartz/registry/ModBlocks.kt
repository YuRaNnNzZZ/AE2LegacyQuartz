package ru.yurannnzzz.ae2quartz.registry

import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.DropExperienceBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument
import net.minecraft.world.level.material.MapColor
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import ru.yurannnzzz.ae2quartz.AE2QuartzMod

object ModBlocks {
	val registry: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, AE2QuartzMod.MOD_ID)

	private val quartsOreBlockBehavior = BlockBehaviour.Properties.of()
		.mapColor(MapColor.STONE)
		.instrument(NoteBlockInstrument.BASEDRUM)
		.requiresCorrectToolForDrops()
		.strength(3.0f, 3.0f)

	val QUARTZ_ORE: RegistryObject<Block> = registry.register("quartz_ore") {
		DropExperienceBlock(
			quartsOreBlockBehavior,
			UniformInt.of(2, 5)
		)
	}
	val DEEPSLATE_QUARTZ_ORE: RegistryObject<Block> = registry.register("deepslate_quartz_ore") {
		DropExperienceBlock(
			quartsOreBlockBehavior
				.mapColor(MapColor.DEEPSLATE)
				.strength(4.5f, 3.0f)
				.sound(SoundType.DEEPSLATE),
			UniformInt.of(2, 5)
		)
	}
}
