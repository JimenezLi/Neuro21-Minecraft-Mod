package jimenezli.neuro21.entity;

import jimenezli.neuro21.entity.boss.hiyori.HiyoriBossEntity;
import jimenezli.neuro21.handler.EntityHandler;
import jimenezli.neuro21.util.NeurosamaType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public class HiyoriEntity extends NeurosamaEntity {
    public HiyoriEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.neurosamaType = NeurosamaType.HIYORI;
    }

    public boolean isAbandoned() {
        return this.hasCustomName() && this.getName().getString().equals("hiyori");
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 0.5D).add(Attributes.MOVEMENT_SPEED, 0.4).add(Attributes.MAX_HEALTH, 20.0);
    }

    public void thunderHit(ServerLevel serverLevel, LightningBolt lightningBolt) {
        if (serverLevel.getDifficulty() != Difficulty.PEACEFUL) {
            HiyoriBossEntity hiyoriBossEntity = EntityHandler.HIYORI_BOSS.get().create(serverLevel);
            assert hiyoriBossEntity != null;
            hiyoriBossEntity.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
            hiyoriBossEntity.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(hiyoriBossEntity.blockPosition()), MobSpawnType.CONVERSION, null, null);
            hiyoriBossEntity.setNoAi(this.isNoAi());
            if (this.hasCustomName()) {
                hiyoriBossEntity.setCustomName(this.getCustomName());
                hiyoriBossEntity.setCustomNameVisible(this.isCustomNameVisible());
            }
            hiyoriBossEntity.setPersistenceRequired();
            serverLevel.addFreshEntityWithPassengers(hiyoriBossEntity);
            this.discard();
        } else {
            super.thunderHit(serverLevel, lightningBolt);
        }
    }
}
