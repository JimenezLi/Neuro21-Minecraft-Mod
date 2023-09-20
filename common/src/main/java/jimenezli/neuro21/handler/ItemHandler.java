package jimenezli.neuro21.handler;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import jimenezli.neuro21.ModRegistries;
import jimenezli.neuro21.Neuro21Mod;
import jimenezli.neuro21.item.*;
import jimenezli.neuro21.item.disc.DiscLivingMillenniumItem;
import jimenezli.neuro21.util.DiscNames;
import jimenezli.neuro21.util.EntityNames;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

import static jimenezli.neuro21.Neuro21Mod.ITEMS;
import static jimenezli.neuro21.Neuro21Mod.prefix;

public class ItemHandler {
    public static final CreativeModeTab NEURO21 = CreativeTabRegistry.create(
            new ResourceLocation(Neuro21Mod.MOD_ID, "neuro21_tab"),
            () -> new ItemStack(ItemHandler.HEART.get())
    );

    public static Item.Properties defaultBuilder() {
        return new Item.Properties().tab(NEURO21);
    }

    private static RegistrySupplier<RecordItem> registerDisc(String discName, Supplier<RecordItem> supplier) {
        return ITEMS.register(prefix("music_disc_" + discName), supplier);
    }

    private static RegistrySupplier<? extends SpawnEggItem> registerSpawnEgg(String entityName, Supplier<? extends SpawnEggItem> supplier) {
        return ITEMS.register(entityName + "_spawn_egg", supplier);
    }

    public static final RegistrySupplier<HeartItem> HEART = ITEMS.register("heart", HeartItem::new);
    public static final RegistrySupplier<IronmilkItem> IRONMILK = ITEMS.register("ironmilk", IronmilkItem::new);
    public static final RegistrySupplier<Item> CHIP = ITEMS.register("chip", ChipItem::new);
    public static final RegistrySupplier<UpgradeChipItem> UPGRADE_CHIP = ITEMS.register("upgrade_chip", UpgradeChipItem::new);
    public static final RegistrySupplier<Item> CHINESE_CABBAGE = ITEMS.register("chinese_cabbage", () -> new ItemNameBlockItem(BlockHandler.CHINESE_CABBAGE_BLOCK.get(), defaultBuilder().food(Foods.CARROT)));
    public static final RegistrySupplier<RecordItem> LIVING_MILLENNIUM = registerDisc(DiscNames.LIVING_MILLENNIUM, DiscLivingMillenniumItem::new);

    public static void register() {
        registerSpawnEgg(EntityNames.VEDAL, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.VEDAL, 0xe7e7e7, 0x00afaf));
        registerSpawnEgg(EntityNames.ANNY, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.ANNY, 0xdcced2, 0xf8f7f7));
        registerSpawnEgg(EntityNames.NEUROSAMA, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.NEUROSAMA, 0xf7e2ce, 0xd2b098));
        registerSpawnEgg(EntityNames.EVIL_NEUROSAMA, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.EVIL_NEUROSAMA, 0x352e25, 0xd2b098));
        registerSpawnEgg(EntityNames.HIYORI, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.HIYORI, 0xfff2d8, 0x9f8b7c));
        registerSpawnEgg(EntityNames.IRON_COW, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.IRON_COW, 0xe9e9e9, 0xc4c4c4));
    }
}
