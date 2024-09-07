package ru.yurannnzzz.ae2quartz.registry

import appeng.items.materials.MaterialItem
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredRegister
import ru.yurannnzzz.ae2quartz.AE2QuartzMod
import java.util.function.Supplier

object ModItems {
	val registry = DeferredRegister.create(BuiltInRegistries.ITEM, AE2QuartzMod.MOD_ID)

	val NETHER_QUARTZ_DUST= registry.register("nether_quartz_dust", Supplier { MaterialItem(Item.Properties()) })

	val QUARTZ_ORE = registry.register("quartz_ore", Supplier { BlockItem(ModBlocks.QUARTZ_ORE.get(), Item.Properties()) })
	val DEEPSLATE_QUARTZ_ORE = registry.register("deepslate_quartz_ore", Supplier { BlockItem(ModBlocks.DEEPSLATE_QUARTZ_ORE.get(), Item.Properties()) })
}
