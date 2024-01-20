package jimenezli.neuro21.forge;

import jimenezli.neuro21.handler.EntityHandler;
import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.ForgeSpawnEggItem;

import java.util.function.Supplier;

public class ModRegistriesImpl {
    public static Supplier<? extends SpawnEggItem> SpawnEggSupplierBuilder(Supplier<? extends EntityType<? extends Mob>> supplier, int primaryColor, int secondaryColor) {
        return () -> new ForgeSpawnEggItem(supplier, primaryColor, secondaryColor, ItemHandler.defaultBuilder());
    }

    public static void setupSpawning() {
        SpawnPlacements.register(EntityHandler.MIYUNE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
    }
}
