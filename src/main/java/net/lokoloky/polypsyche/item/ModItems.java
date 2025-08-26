package net.lokoloky.polypsyche.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lokoloky.polypsyche.Polypsyche;
import net.lokoloky.polypsyche.custom.item.ChiselItem;
import net.lokoloky.polypsyche.custom.item.NetheratorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(64)));
    public static final Item NETHERATOR = registerItem("netherator", new NetheratorItem(new Item.Settings().maxDamage(1)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Polypsyche.MOD_ID, name), item);
    }
    public static void registerModItem() {
        Polypsyche.LOGGER.info("Registering mod item for " + Polypsyche.MOD_ID);
    }
}
