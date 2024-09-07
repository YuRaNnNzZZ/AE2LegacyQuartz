package ru.yurannnzzz.ae2quartz.registry

import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.level.block.DropExperienceBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument
import net.minecraft.world.level.material.MapColor
import net.neoforged.neoforge.registries.DeferredRegister
import ru.yurannnzzz.ae2quartz.AE2QuartzMod
import java.util.function.Supplier

object ModBlocks {
	val registry = DeferredRegister.createBlocks(AE2QuartzMod.MOD_ID)

	private val quartsOreBlockBehavior = BlockBehaviour.Properties.of()
		.mapColor(MapColor.STONE)
		.instrument(NoteBlockInstrument.BASEDRUM)
		.requiresCorrectToolForDrops()
		.strength(3.0f, 3.0f)

	val QUARTZ_ORE = registry.register("quartz_ore", Supplier {
		DropExperienceBlock(
			UniformInt.of(2, 5),
			quartsOreBlockBehavior
		)
	})

	val DEEPSLATE_QUARTZ_ORE = registry.register("deepslate_quartz_ore", Supplier {
		DropExperienceBlock(
			UniformInt.of(2, 5),
			quartsOreBlockBehavior
				.mapColor(MapColor.DEEPSLATE)
				.strength(4.5f, 3.0f)
				.sound(SoundType.DEEPSLATE)
		)
	})
}
