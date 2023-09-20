package jimenezli.neuro21.forge;

import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;

import java.util.function.Supplier;

public class ModRegistriesImpl {
    public static Supplier<? extends SpawnEggItem> SpawnEggSupplierBuilder(Supplier<? extends EntityType<? extends Mob>> supplier, int primaryColor, int secondaryColor) {
        return () -> new ForgeSpawnEggItem(supplier, primaryColor, secondaryColor, ItemHandler.defaultBuilder());
    }
}
