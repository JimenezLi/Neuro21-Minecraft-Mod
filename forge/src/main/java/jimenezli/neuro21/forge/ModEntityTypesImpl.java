package jimenezli.neuro21.forge;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import jimenezli.neuro21.Neuro21Mod;
import jimenezli.neuro21.entity.*;
import jimenezli.neuro21.handler.EntityHandler;
import jimenezli.neuro21.util.NeurosamaType;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Neuro21Mod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityTypesImpl {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Neuro21Mod.MOD_ID, Registry.ENTITY_TYPE_REGISTRY);

    public static final RegistrySupplier<EntityType<VedalEntity>> VEDAL = ENTITIES.register(EntityHandler.VEDAL_NAME, EntityHandler.VEDAL);
    public static final RegistrySupplier<EntityType<AnnyEntity>> ANNY = ENTITIES.register(EntityHandler.ANNY_NAME, EntityHandler.ANNY);
    public static final RegistrySupplier<EntityType<NeurosamaEntity>> NEUROSAMA = ENTITIES.register(EntityHandler.NEUROSAMA_NAME, EntityHandler.NEUROSAMA);
    public static final RegistrySupplier<EntityType<EvilNeurosamaEntity>> EVIL_NEUROSAMA = ENTITIES.register(EntityHandler.EVIL_NEUROSAMA_NAME, EntityHandler.EVIL_NEUROSAMA);
    public static final RegistrySupplier<EntityType<HiyoriEntity>> HIYORI = ENTITIES.register(EntityHandler.HIYORI_NAME, EntityHandler.HIYORI);
    public static final RegistrySupplier<EntityType<IronCowEntity>> IRON_COW = ENTITIES.register(EntityHandler.IRON_COW_NAME, EntityHandler.IRON_COW);

    public static void register(Object optionalEvent) {
        ENTITIES.register();
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(VEDAL.get(), VedalEntity.createAttributes().build());
        event.put(ANNY.get(), AnnyEntity.createAttributes().build());
        event.put(NEUROSAMA.get(), NeurosamaEntity.createAttributes().build());
        event.put(EVIL_NEUROSAMA.get(), EvilNeurosamaEntity.createAttributes().build());
        event.put(HIYORI.get(), HiyoriEntity.createAttributes().build());
        event.put(IRON_COW.get(), IronCowEntity.createAttributes().build());
    }

    public static EntityType<VedalEntity> getVedalEntity() {
        return VEDAL.get();
    }

    public static EntityType<AnnyEntity> getAnnyEntity() {
        return ANNY.get();
    }

    public static EntityType<? extends NeurosamaEntity> getNeurosamaEntity(NeurosamaType type) {
        return switch (type) {
            case HIYORI -> HIYORI.get();
            case EVIL_NEUROSAMA -> EVIL_NEUROSAMA.get();
            default -> NEUROSAMA.get();
        };
    }

    public static EntityType<IronCowEntity> getIronCowEntity() {
        return IRON_COW.get();
    }
}
