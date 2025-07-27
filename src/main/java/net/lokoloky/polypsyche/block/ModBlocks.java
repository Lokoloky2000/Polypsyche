package net.lokoloky.polypsyche.block;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lokoloky.polypsyche.Polypsyche;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    private static final Block PINK_GARNET_BLOCK = registerBlock("PINK_GARNET_BLOCK", new Block(
            AbstractBlock.Settings.create().
                    strength(4f).
                    requiresTool().
                    sounds(BlockSoundGroup.NETHERITE)
    ));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Polypsyche.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Polypsyche.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerBlocks() {
        Polypsyche.LOGGER.info("Registering mod blocks for " + Polypsyche.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(PINK_GARNET_BLOCK);
        });
    }
}
