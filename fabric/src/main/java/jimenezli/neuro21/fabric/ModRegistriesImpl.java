package jimenezli.neuro21.fabric;

import jimenezli.neuro21.entity.MiyuneEntity;
import jimenezli.neuro21.handler.EntityHandler;
import jimenezli.neuro21.handler.ItemHandler;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.function.Supplier;

public class ModRegistriesImpl {
    public static Supplier<? extends SpawnEggItem> SpawnEggSupplierBuilder(Supplier<? extends EntityType<? extends Mob>> supplier, int primaryColor, int secondaryColor) {
        return () -> new SpawnEggItem(supplier.get(), primaryColor, secondaryColor, ItemHandler.defaultBuilder());
    }

    public static void setupSpawning() {
        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), MobCategory.CREATURE, EntityHandler.MIYUNE.get(), 10, 1, 1);
        SpawnPlacements.register(EntityHandler.MIYUNE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
    }
}
