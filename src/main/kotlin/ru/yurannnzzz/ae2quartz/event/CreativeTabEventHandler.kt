package ru.yurannnzzz.ae2quartz.event

import appeng.api.ids.AECreativeTabIds
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
import ru.yurannnzzz.ae2quartz.registry.ModItems

fun addCreativeTabItems(event: BuildCreativeModeTabContentsEvent) {
	if (event.tabKey === AECreativeTabIds.MAIN) {
		event.accept(ModItems.QUARTZ_ORE.get())
		event.accept(ModItems.DEEPSLATE_QUARTZ_ORE.get())
		event.accept(ModItems.NETHER_QUARTZ_DUST.get())
	}
}
