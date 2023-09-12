package jimenezli.neuro21;

import dev.architectury.injectables.annotations.ExpectPlatform;
import jimenezli.neuro21.entity.AnnyEntity;
import jimenezli.neuro21.entity.IronCowEntity;
import jimenezli.neuro21.entity.NeurosamaEntity;
import jimenezli.neuro21.entity.VedalEntity;
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
    public static EntityType<NeurosamaEntity> getNeurosamaEntity() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static EntityType<IronCowEntity> getIronCowEntity() {
        throw new AssertionError();
    }
}
