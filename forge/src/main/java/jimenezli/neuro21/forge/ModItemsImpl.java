package jimenezli.neuro21.forge;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jimenezli.neuro21.ModEntityTypes;
import jimenezli.neuro21.ModSoundEvents;
import jimenezli.neuro21.Neuro21Mod;
import jimenezli.neuro21.handler.SoundHandler;
import jimenezli.neuro21.util.Neuro21DiscType;
import jimenezli.neuro21.util.NeurosamaType;
import jimenezli.neuro21.handler.EntityHandler;
import jimenezli.neuro21.handler.ItemHandler;
import jimenezli.neuro21.item.HeartItem;
import jimenezli.neuro21.item.IronmilkItem;
import jimenezli.neuro21.item.UpgradeChipItem;
import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;

import java.util.function.Supplier;

import static jimenezli.neuro21.Neuro21Mod.prefix;

public class ModItemsImpl {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Neuro21Mod.MOD_ID, Registry.ITEM_REGISTRY);

    public static final RegistrySupplier<HeartItem> HEART = ITEMS.register(ItemHandler.HEART_NAME, ItemHandler.HEART_ITEM);
    public static final RegistrySupplier<IronmilkItem> IRONMILK = ITEMS.register(ItemHandler.IRONMILK_NAME, ItemHandler.IRONMILK_ITEM);
    public static final RegistrySupplier<Item> CHIP = ITEMS.register(ItemHandler.CHIP_NAME, ItemHandler.CHIP_ITEM);
    public static final RegistrySupplier<UpgradeChipItem> UPGRADE_CHIP = ITEMS.register(ItemHandler.UPGRADE_CHIP_NAME, ItemHandler.UPGRADE_CHIP_ITEM);

    static {
        registerDisc(SoundHandler.DISC_LIVING_MILLENNIUM, ItemHandler.DISC_LIVING_MILLENNIUM_ITEM);

        registerSpawnEgg(EntityHandler.VEDAL_NAME, ModEntityTypes::getVedalEntity, 0xe7e7e7, 0x00afaf);
        registerSpawnEgg(EntityHandler.ANNY_NAME, ModEntityTypes::getAnnyEntity, 0xdcced2, 0xf8f7f7);
        registerSpawnEgg(EntityHandler.NEUROSAMA_NAME, () -> ModEntityTypes.getNeurosamaEntity(NeurosamaType.NEUROSAMA), 0xf7e2ce, 0xd2b098);
        registerSpawnEgg(EntityHandler.EVIL_NEUROSAMA_NAME, () -> ModEntityTypes.getNeurosamaEntity(NeurosamaType.EVIL_NEUROSAMA), 0x352e25, 0xd2b098);
        registerSpawnEgg(EntityHandler.HIYORI_NAME, () -> ModEntityTypes.getNeurosamaEntity(NeurosamaType.HIYORI), 0xfff2d8, 0x9f8b7c);
        registerSpawnEgg(EntityHandler.IRON_COW_NAME, ModEntityTypes::getIronCowEntity, 0xe9e9e9, 0xc4c4c4);
    }

    public static void register(Object optionalEvent) {
        ITEMS.register();
    }

    private static RegistrySupplier<ForgeSpawnEggItem> registerSpawnEgg(String entityName, Supplier<? extends EntityType<? extends Mob>> supplier, int primaryColor, int secondaryColor) {
        return ITEMS.register(entityName + "_spawn_egg", () -> new ForgeSpawnEggItem(supplier, primaryColor, secondaryColor, ItemHandler.defaultBuilder()));
    }

    private static RegistrySupplier<RecordItem> registerDisc(String discName, Supplier<RecordItem> supplier) {
        return ITEMS.register(prefix("music_disc_" + discName), supplier);
    }

    public static Item getHeartItem() {
        return HEART.get();
    }

    public static Item getIronmilkItem() {
        return IRONMILK.get();
    }

    public static Item getChipItem() {
        return CHIP.get();
    }
}
