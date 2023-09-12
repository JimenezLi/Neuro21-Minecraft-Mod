package jimenezli.neuro21.handler;

import dev.architectury.registry.CreativeTabRegistry;
import jimenezli.neuro21.ModItems;
import jimenezli.neuro21.Neuro21Mod;
import jimenezli.neuro21.item.ChipItem;
import jimenezli.neuro21.item.HeartItem;
import jimenezli.neuro21.item.IronmilkItem;
import jimenezli.neuro21.item.UpgradeChipItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;

import java.util.function.Supplier;

public class ItemHandler {
    public static final CreativeModeTab NEURO21 = CreativeTabRegistry.create(
            new ResourceLocation(Neuro21Mod.MOD_ID, "neuro21_tab"),
            () -> new ItemStack(ModItems.getHeartItem())
    );

    public static Item.Properties defaultBuilder() {
        return new Item.Properties().tab(NEURO21);
    }

    public static Supplier<SpawnEggItem> spawnEggSupplierBuilder(EntityType<? extends Mob> type, int primaryColor, int secondaryColor) {
        return () -> new SpawnEggItem(type, primaryColor, secondaryColor, defaultBuilder());
    }

    public static final String HEART_NAME = "heart";
    public static final Supplier<HeartItem> HEART_ITEM = HeartItem::new;

    public static final String IRONMILK_NAME = "ironmilk";
    public static final Supplier<IronmilkItem> IRONMILK_ITEM = IronmilkItem::new;

    public static final String CHIP_NAME = "chip";
    public static final Supplier<ChipItem> CHIP_ITEM = ChipItem::new;

    public static final String UPGRADE_CHIP_NAME = "upgrade_chip";
    public static final Supplier<UpgradeChipItem> UPGRADE_CHIP_ITEM = UpgradeChipItem::new;
}
