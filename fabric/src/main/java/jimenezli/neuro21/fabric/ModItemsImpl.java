package jimenezli.neuro21.fabric;

import jimenezli.neuro21.Neuro21Mod;
import jimenezli.neuro21.entity.VedalEntity;
import jimenezli.neuro21.handler.EntityHandler;
import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

import java.util.function.Supplier;

import static jimenezli.neuro21.Neuro21Mod.prefix;

public class ModItemsImpl {
    public static Item HEART;
    public static Item IRONMILK;
    public static Item CHIP;
    public static Item UPGRADE_CHIP;

    public static void register(Object optionalEvent) {
        HEART = Registry.register(Registry.ITEM, prefix(ItemHandler.HEART_NAME), ItemHandler.HEART_ITEM.get());
        IRONMILK = Registry.register(Registry.ITEM, prefix(ItemHandler.IRONMILK_NAME), ItemHandler.IRONMILK_ITEM.get());
        CHIP = Registry.register(Registry.ITEM, prefix(ItemHandler.CHIP_NAME), ItemHandler.CHIP_ITEM.get());
        UPGRADE_CHIP = Registry.register(Registry.ITEM, prefix(ItemHandler.UPGRADE_CHIP_NAME), ItemHandler.UPGRADE_CHIP_ITEM.get());

        registerSpawnEgg(EntityHandler.VEDAL_NAME, ItemHandler.spawnEggSupplierBuilder(ModEntityTypesImpl.VEDAL, 0xe7e7e7, 0x00afaf));
        registerSpawnEgg(EntityHandler.ANNY_NAME, ItemHandler.spawnEggSupplierBuilder(ModEntityTypesImpl.ANNY, 0xdcced2, 0xf8f7f7));
        registerSpawnEgg(EntityHandler.NEUROSAMA_NAME, ItemHandler.spawnEggSupplierBuilder(ModEntityTypesImpl.NEUROSAMA, 0xf7e2ce, 0xd2b098));
        registerSpawnEgg(EntityHandler.EVIL_NEUROSAMA_NAME, ItemHandler.spawnEggSupplierBuilder(ModEntityTypesImpl.EVIL_NEUROSAMA, 0x352e25, 0xd2b098));
        registerSpawnEgg(EntityHandler.HIYORI_NAME, ItemHandler.spawnEggSupplierBuilder(ModEntityTypesImpl.HIYORI, 0xfff2d8, 0x9f8b7c));
        registerSpawnEgg(EntityHandler.IRON_COW_NAME, ItemHandler.spawnEggSupplierBuilder(ModEntityTypesImpl.IRON_COW, 0xe9e9e9, 0xc4c4c4));
    }

    private static Item registerSpawnEgg(String entityName, Supplier<SpawnEggItem> supplier) {
        return Registry.register(Registry.ITEM, prefix(entityName + "_spawn_egg"), supplier.get());
    }

    public static Item getHeartItem() {
        return HEART;
    }

    public static Item getIronmilkItem() {
        return IRONMILK;
    }

    public static Item getChipItem() {
        return CHIP;
    }
}
