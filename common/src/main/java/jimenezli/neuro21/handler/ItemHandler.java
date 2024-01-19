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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
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

    public static final RegistrySupplier<Item> HEART = ITEMS.register("heart", () -> new Item(defaultBuilder()));
    public static final RegistrySupplier<Neuro21DoughnutItem> NEURO21_DONUT = ITEMS.register("neuro21_doughnut", Neuro21DoughnutItem::new);
    public static final RegistrySupplier<Item> MELBA_TOAST = ITEMS.register("melba_toast", () -> new Item(defaultBuilder().food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).alwaysEat().effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 0.6F).build())));
    public static final RegistrySupplier<Item> BURNT_MELBA = ITEMS.register("burnt_melba", () -> new Item(defaultBuilder().food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).alwaysEat().effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1), 0.6F).build())));
    public static final RegistrySupplier<Item> CHIP = ITEMS.register("chip", ChipItem::new);
    public static final RegistrySupplier<UpgradeChipItem> UPGRADE_CHIP = ITEMS.register("upgrade_chip", UpgradeChipItem::new);
    public static final RegistrySupplier<Item> CHINESE_CABBAGE = ITEMS.register("chinese_cabbage", () -> new ItemNameBlockItem(BlockHandler.CHINESE_CABBAGE_BLOCK.get(), defaultBuilder().food(Foods.CARROT)));
    public static final RegistrySupplier<RecordItem> LIVING_MILLENNIUM = registerDisc(DiscNames.LIVING_MILLENNIUM, DiscLivingMillenniumItem::new);

    public static void register() {
        registerSpawnEgg(EntityNames.VEDAL, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.VEDAL, 0xe7e7e7, 0x00afaf));
        registerSpawnEgg(EntityNames.GIGA_VEDAL, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.GIGA_VEDAL, 0x004d2b, 0x00afaf));
        registerSpawnEgg(EntityNames.MIYUNE, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.MIYUNE, 0x38cfc9, 0xff990b));
        registerSpawnEgg(EntityNames.ANNY, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.ANNY, 0xdcced2, 0xf8f7f7));
        registerSpawnEgg(EntityNames.NEUROSAMA, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.NEUROSAMA, 0xf7e2ce, 0xd2b098));
        registerSpawnEgg(EntityNames.EVIL_NEUROSAMA, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.EVIL_NEUROSAMA, 0x352e25, 0xd2b098));
        registerSpawnEgg(EntityNames.HIYORI, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.HIYORI, 0xfff2d8, 0x9f8b7c));
        registerSpawnEgg(EntityNames.GYMBAG, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.GYMBAG, 0x7a5052, 0xb4686c));
        registerSpawnEgg(EntityNames.SWARM_DRONE, ModRegistries.SpawnEggSupplierBuilder(EntityHandler.SWARM_DRONE, 0xffffff, 0xe4e4e4));
    }
}
