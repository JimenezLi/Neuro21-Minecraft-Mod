package jimenezli.neuro21.handler;

import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import jimenezli.neuro21.entity.*;
import jimenezli.neuro21.entity.boss.hiyori.GymbagEntity;
import jimenezli.neuro21.entity.boss.hiyori.HiyoriBossEntity;
import jimenezli.neuro21.entity.boss.hiyori.SwarmDroneEntity;
import jimenezli.neuro21.util.EntityNames;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

import static jimenezli.neuro21.Neuro21Mod.ENTITY_TYPES;
import static jimenezli.neuro21.Neuro21Mod.prefix;
import static jimenezli.neuro21.util.Parameters.hiyoriBossScale;

public class EntityHandler {
    public static final Supplier<EntityType<VedalEntity>> VEDAL = registerLivingEntity(
            EntityNames.VEDAL,
            EntityType.Builder.of(VedalEntity::new, MobCategory.CREATURE).sized(1.2F, 0.4F).clientTrackingRange(10),
            VedalEntity::createAttributes
    );

    public static final Supplier<EntityType<GigaVedalEntity>> GIGA_VEDAL = registerLivingEntity(
            EntityNames.GIGA_VEDAL,
            EntityType.Builder.of(GigaVedalEntity::new, MobCategory.CREATURE),
            GigaVedalEntity::createAttributes
    );

    public static final Supplier<EntityType<MiyuneEntity>> MIYUNE = registerLivingEntity(
            EntityNames.MIYUNE,
            EntityType.Builder.of(MiyuneEntity::new, MobCategory.CREATURE),
            MiyuneEntity::createAttributes
    );

    public static final Supplier<EntityType<AnnyEntity>> ANNY = registerLivingEntity(
            EntityNames.ANNY,
            EntityType.Builder.of(AnnyEntity::new, MobCategory.CREATURE).sized(0.6F, 0.7F).clientTrackingRange(8).immuneTo(Blocks.SWEET_BERRY_BUSH),
            AnnyEntity::createAttributes
    );

    public static final RegistrySupplier<EntityType<NeurosamaEntity>> NEUROSAMA = registerLivingEntity(
            EntityNames.NEUROSAMA,
            EntityType.Builder.of(NeurosamaEntity::new, MobCategory.CREATURE),
            NeurosamaEntity::createAttributes
    );

    public static final RegistrySupplier<EntityType<EvilNeurosamaEntity>> EVIL_NEUROSAMA = registerLivingEntity(
            EntityNames.EVIL_NEUROSAMA,
            EntityType.Builder.of(EvilNeurosamaEntity::new, MobCategory.CREATURE),
            EvilNeurosamaEntity::createAttributes
    );

    public static final RegistrySupplier<EntityType<HiyoriEntity>> HIYORI = registerLivingEntity(
            EntityNames.HIYORI,
            EntityType.Builder.of(HiyoriEntity::new, MobCategory.CREATURE),
            HiyoriEntity::createAttributes
    );

    public static final RegistrySupplier<EntityType<HiyoriBossEntity>> HIYORI_BOSS = registerLivingEntity(
            EntityNames.HIYORI_BOSS,
            EntityType.Builder.of(HiyoriBossEntity::new, MobCategory.MONSTER).sized(0.6F * hiyoriBossScale, 1.8F * hiyoriBossScale).clientTrackingRange(40),
            HiyoriBossEntity::createAttributes
    );

    public static final RegistrySupplier<EntityType<GymbagEntity>> GYMBAG = registerLivingEntity(
            EntityNames.GYMBAG,
            EntityType.Builder.of(GymbagEntity::new, MobCategory.MONSTER).sized(1.0F,  1.0F),
            GymbagEntity::createAttributes
    );

    public static final RegistrySupplier<EntityType<SwarmDroneEntity>> SWARM_DRONE = registerLivingEntity(
            EntityNames.SWARM_DRONE,
            EntityType.Builder.of(SwarmDroneEntity::new, MobCategory.MONSTER).sized(1.0F, 1.0F),
            SwarmDroneEntity::createAttributes
    );

    private static <T extends LivingEntity> RegistrySupplier<EntityType<T>> registerLivingEntity(String name, EntityType.Builder<T> builder, Supplier<AttributeSupplier.Builder> attributeSupplier) {
        ResourceLocation id = prefix(name);
        return ENTITY_TYPES.register(id, () -> {
            EntityType<T> result = builder.build(id.toString());
            EntityAttributeRegistry.register(() -> result, attributeSupplier);
            return result;
        });
    }

    public static void register() {
    }
}
