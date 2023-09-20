package jimenezli.neuro21;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.SpawnEggItem;

import java.util.function.Supplier;

public class ModRegistries {
    @ExpectPlatform
    public static Supplier<? extends SpawnEggItem> SpawnEggSupplierBuilder(Supplier<? extends EntityType<? extends Mob>> supplier, int primaryColor, int secondaryColor) {
        throw new AssertionError();
    }
}
