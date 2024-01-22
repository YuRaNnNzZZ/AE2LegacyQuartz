package ru.yurannnzzz.ae2quartz.registry

import appeng.items.materials.MaterialItem
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import ru.yurannnzzz.ae2quartz.AE2QuartzMod

object ModItems {
	val registry: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, AE2QuartzMod.MOD_ID)

	val NETHER_QUARTZ_DUST: RegistryObject<Item> = registry.register("nether_quartz_dust") {
		MaterialItem(Item.Properties())
	}

	val QUARTZ_ORE: RegistryObject<Item> = registry.register("quartz_ore") {
		BlockItem(ModBlocks.QUARTZ_ORE.get(), Item.Properties())
	}
	val DEEPSLATE_QUARTZ_ORE: RegistryObject<Item> = registry.register("deepslate_quartz_ore") {
		BlockItem(ModBlocks.DEEPSLATE_QUARTZ_ORE.get(), Item.Properties())
	}
}
