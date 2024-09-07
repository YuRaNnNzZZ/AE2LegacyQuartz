package ru.yurannnzzz.ae2quartz.data.server

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

object ModTags {
	val CERTUS_QUARTZ_ORE_BLOCK: TagKey<Block> =
		TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "ores/certus_quartz"))
	val CERTUS_QUARTZ_ORE: TagKey<Item> =
		TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ores/certus_quartz"))
	val NETHER_QUARTZ_DUST: TagKey<Item> = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "dusts/quartz"))
}
