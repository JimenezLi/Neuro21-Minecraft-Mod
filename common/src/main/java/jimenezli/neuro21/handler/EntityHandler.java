package jimenezli.neuro21.handler;

import jimenezli.neuro21.Neuro21Mod;
import jimenezli.neuro21.entity.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public class EntityHandler {
    public static final String VEDAL_NAME = "vedal";
    public static final Supplier<EntityType<VedalEntity>> VEDAL = () -> (EntityType<VedalEntity>) build(EntityHandler.VEDAL_NAME,
            EntityType.Builder.of(VedalEntity::new, MobCategory.CREATURE).sized(1.2F, 0.4F).clientTrackingRange(10));

    public static final String ANNY_NAME = "anny";
    public static final Supplier<EntityType<AnnyEntity>> ANNY = () -> (EntityType<AnnyEntity>) build(EntityHandler.ANNY_NAME,
            EntityType.Builder.of(AnnyEntity::new, MobCategory.CREATURE).sized(0.6F, 0.7F).clientTrackingRange(8).immuneTo(Blocks.SWEET_BERRY_BUSH));

    public static final String NEUROSAMA_NAME = "neurosama";
    public static final Supplier<EntityType<NeurosamaEntity>> NEUROSAMA = () -> (EntityType<NeurosamaEntity>) build(EntityHandler.NEUROSAMA_NAME,
            EntityType.Builder.of(NeurosamaEntity::new, MobCategory.CREATURE));

    public static final String EVIL_NEUROSAMA_NAME = "evil_neurosama";
    public static final Supplier<EntityType<EvilNeurosamaEntity>> EVIL_NEUROSAMA = () -> (EntityType<EvilNeurosamaEntity>) build(EntityHandler.EVIL_NEUROSAMA_NAME,
            EntityType.Builder.of(EvilNeurosamaEntity::new, MobCategory.CREATURE));

    public static final String HIYORI_NAME = "hiyori";
    public static final Supplier<EntityType<HiyoriEntity>> HIYORI = () -> (EntityType<HiyoriEntity>) build(EntityHandler.HIYORI_NAME,
            EntityType.Builder.of(HiyoriEntity::new, MobCategory.CREATURE));

    public static final String IRON_COW_NAME = "iron_cow";
    public static final Supplier<EntityType<IronCowEntity>> IRON_COW = () -> (EntityType<IronCowEntity>) build(EntityHandler.IRON_COW_NAME,
            EntityType.Builder.of(IronCowEntity::new, MobCategory.CREATURE).sized(0.9F, 1.4F).clientTrackingRange(10));


    public static EntityType<?> build(String id, EntityType.Builder<?> builder) {
        String prefixedId = Neuro21Mod.MOD_ID + ":" + id;
        return builder.build(prefixedId);
    }
}
