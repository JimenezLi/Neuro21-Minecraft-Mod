package jimenezli.neuro21.fabric;

import jimenezli.neuro21.entity.*;
import jimenezli.neuro21.handler.EntityHandler;
import jimenezli.neuro21.util.NeurosamaType;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;

import static jimenezli.neuro21.Neuro21Mod.prefix;

public class ModEntityTypesImpl {
    public static EntityType<VedalEntity> VEDAL;
    public static EntityType<AnnyEntity> ANNY;
    public static EntityType<NeurosamaEntity> NEUROSAMA;

    public static EntityType<EvilNeurosamaEntity> EVIL_NEUROSAMA;

    public static EntityType<HiyoriEntity> HIYORI;
    public static EntityType<IronCowEntity> IRON_COW;

    public static void register(Object optionalEvent) {
        VEDAL = Registry.register(Registry.ENTITY_TYPE, prefix(EntityHandler.VEDAL_NAME), EntityHandler.VEDAL.get());
        ANNY = Registry.register(Registry.ENTITY_TYPE, prefix(EntityHandler.ANNY_NAME), EntityHandler.ANNY.get());
        NEUROSAMA = Registry.register(Registry.ENTITY_TYPE, prefix(EntityHandler.NEUROSAMA_NAME), EntityHandler.NEUROSAMA.get());
        EVIL_NEUROSAMA = Registry.register(Registry.ENTITY_TYPE, prefix(EntityHandler.EVIL_NEUROSAMA_NAME), EntityHandler.EVIL_NEUROSAMA.get());
        HIYORI = Registry.register(Registry.ENTITY_TYPE, prefix(EntityHandler.HIYORI_NAME), EntityHandler.HIYORI.get());
        IRON_COW = Registry.register(Registry.ENTITY_TYPE, prefix(EntityHandler.IRON_COW_NAME), EntityHandler.IRON_COW.get());
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntityTypesImpl.VEDAL, VedalEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityTypesImpl.ANNY, AnnyEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityTypesImpl.NEUROSAMA, NeurosamaEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityTypesImpl.EVIL_NEUROSAMA, EvilNeurosamaEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityTypesImpl.HIYORI, HiyoriEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityTypesImpl.IRON_COW, IronCowEntity.createAttributes());
    }

    public static EntityType<VedalEntity> getVedalEntity() {
        return VEDAL;
    }

    public static EntityType<AnnyEntity> getAnnyEntity() {
        return ANNY;
    }

    public static EntityType<? extends NeurosamaEntity> getNeurosamaEntity(NeurosamaType type) {
        return switch (type) {
            case HIYORI -> HIYORI;
            case EVIL_NEUROSAMA -> EVIL_NEUROSAMA;
            default -> NEUROSAMA;
        };
    }

    public static EntityType<IronCowEntity> getIronCowEntity() {
        return IRON_COW;
    }
}
