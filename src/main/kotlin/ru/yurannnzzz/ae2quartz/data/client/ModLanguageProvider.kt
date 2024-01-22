package ru.yurannnzzz.ae2quartz.data.client

import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.LanguageProvider
import ru.yurannnzzz.ae2quartz.registry.ModBlocks
import ru.yurannnzzz.ae2quartz.registry.ModItems

class English(output: PackOutput?, modid: String?) : LanguageProvider(output, modid, "en_us") {
	override fun addTranslations() {
		addBlock(ModBlocks.QUARTZ_ORE, "Certus Quartz Ore")
		addBlock(ModBlocks.DEEPSLATE_QUARTZ_ORE, "Deepslate Certus Quartz Ore")

		addItem(ModItems.NETHER_QUARTZ_DUST, "Nether Quartz Dust")
	}
}

class Russian(output: PackOutput?, modid: String?) : LanguageProvider(output, modid, "ru_ru") {
	override fun addTranslations() {
		addBlock(ModBlocks.QUARTZ_ORE, "Руда истинного кварца")
		addBlock(ModBlocks.DEEPSLATE_QUARTZ_ORE, "Глубокосланцевая руда истинного кварца")

		addItem(ModItems.NETHER_QUARTZ_DUST, "Пыль незер-кварца")
	}
}
