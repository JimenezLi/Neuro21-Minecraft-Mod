package jimenezli.neuro21.fabric;

import jimenezli.neuro21.Neuro21Mod;
import jimenezli.neuro21.entity.AnnyEntity;
import jimenezli.neuro21.entity.IronCowEntity;
import jimenezli.neuro21.entity.NeurosamaEntity;
import jimenezli.neuro21.entity.VedalEntity;
import jimenezli.neuro21.handler.EntityHandler;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.ResourceLocationException;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;

import static jimenezli.neuro21.Neuro21Mod.prefix;

public class ModEntityTypesImpl {
    public static EntityType<VedalEntity> VEDAL;
    public static EntityType<AnnyEntity> ANNY;
    public static EntityType<NeurosamaEntity> NEUROSAMA;
    public static EntityType<IronCowEntity> IRON_COW;

    public static void register(Object optionalEvent) {
        VEDAL = Registry.register(Registry.ENTITY_TYPE, prefix(EntityHandler.VEDAL_NAME), EntityHandler.VEDAL.get());
        ANNY = Registry.register(Registry.ENTITY_TYPE, prefix(EntityHandler.ANNY_NAME), EntityHandler.ANNY.get());
        NEUROSAMA = Registry.register(Registry.ENTITY_TYPE, prefix(EntityHandler.NEUROSAMA_NAME), EntityHandler.NEUROSAMA.get());
        IRON_COW = Registry.register(Registry.ENTITY_TYPE, prefix(EntityHandler.IRON_COW_NAME), EntityHandler.IRON_COW.get());
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntityTypesImpl.VEDAL, VedalEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityTypesImpl.ANNY, AnnyEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityTypesImpl.NEUROSAMA, NeurosamaEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityTypesImpl.IRON_COW, IronCowEntity.createAttributes());
    }

    public static EntityType<VedalEntity> getVedalEntity() {
        return VEDAL;
    }

    public static EntityType<AnnyEntity> getAnnyEntity() {
        return ANNY;
    }

    public static EntityType<NeurosamaEntity> getNeurosamaEntity() {
        return NEUROSAMA;
    }
}
