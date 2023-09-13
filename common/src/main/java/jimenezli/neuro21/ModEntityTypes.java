package jimenezli.neuro21;

import dev.architectury.injectables.annotations.ExpectPlatform;
import jimenezli.neuro21.entity.*;
import net.minecraft.world.entity.EntityType;

public class ModEntityTypes {
    @ExpectPlatform
    public static void register(Object optionalEvent) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void registerAttributes() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static EntityType<VedalEntity> getVedalEntity() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static EntityType<AnnyEntity> getAnnyEntity() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static EntityType<? extends NeurosamaEntity> getNeurosamaEntity(NeurosamaType type) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static EntityType<IronCowEntity> getIronCowEntity() {
        throw new AssertionError();
    }
}
