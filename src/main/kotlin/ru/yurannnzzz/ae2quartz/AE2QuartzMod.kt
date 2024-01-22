package ru.yurannnzzz.ae2quartz

import net.minecraftforge.fml.common.Mod
import ru.yurannnzzz.ae2quartz.data.onDataGather
import ru.yurannnzzz.ae2quartz.event.addCreativeTabItems
import ru.yurannnzzz.ae2quartz.registry.ModBlocks
import ru.yurannnzzz.ae2quartz.registry.ModItems
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(AE2QuartzMod.MOD_ID)
object AE2QuartzMod {
	const val MOD_ID = "ae2quartz"

	init {
		ModBlocks.registry.register(MOD_BUS)
		ModItems.registry.register(MOD_BUS)

		MOD_BUS.addListener(::addCreativeTabItems)
		MOD_BUS.addListener(::onDataGather)
	}
}
