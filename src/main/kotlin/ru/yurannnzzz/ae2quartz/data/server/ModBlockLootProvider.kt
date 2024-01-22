package ru.yurannnzzz.ae2quartz.data.server

import appeng.core.definitions.AEItems
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.entries.LootItem
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator
import net.minecraftforge.registries.RegistryObject
import ru.yurannnzzz.ae2quartz.registry.ModBlocks

class ModBlockLootProvider : BlockLootSubProvider(emptySet(), FeatureFlags.REGISTRY.allFlags()) {
	override fun generate() {
		add(ModBlocks.QUARTZ_ORE.get(), this::createCertusQuartsOreDrops)
		add(ModBlocks.DEEPSLATE_QUARTZ_ORE.get(), this::createCertusQuartsOreDrops)
	}

	override fun getKnownBlocks(): Iterable<Block> {
		return Iterable {
			ModBlocks.registry.entries
				.stream()
				.flatMap { obj: RegistryObject<Block> -> obj.stream() }
				.iterator()
		}
	}

	private fun createCertusQuartsOreDrops(block: Block): LootTable.Builder {
		return createSilkTouchDispatchTable(
			block,
			applyExplosionDecay(
				block,
				LootItem.lootTableItem(AEItems.CERTUS_QUARTZ_CRYSTAL)
					.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
					.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
			)
		)
	}
}
