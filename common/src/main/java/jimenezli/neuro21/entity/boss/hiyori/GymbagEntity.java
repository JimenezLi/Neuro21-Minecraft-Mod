package jimenezli.neuro21.entity.boss.hiyori;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

/**
 * Most of the code is copied from Creeper.
 */
public class GymbagEntity extends Monster {
    private static final EntityDataAccessor<Integer> DATA_SWELL_DIR;
    private int oldSwell;
    private int swell;
    private int maxSwell = 30;

    public GymbagEntity(EntityType<? extends GymbagEntity> entityType, Level level) {
        super(entityType, level);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new GymbagSwellGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    public int getMaxFallDistance() {
        return this.getTarget() == null ? 3 : 3 + (int)(this.getHealth() - 1.0F);
    }

    public boolean causeFallDamage(float f, float g, DamageSource damageSource) {
        boolean bl = super.causeFallDamage(f, g, damageSource);
        this.swell += (int)(f * 1.5F);
        if (this.swell > this.maxSwell - 5) {
            this.swell = this.maxSwell - 5;
        }
        return bl;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_SWELL_DIR, -1);
    }

    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putShort("Fuse", (short)this.maxSwell);
    }

    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("Fuse", 99)) {
            this.maxSwell = compoundTag.getShort("Fuse");
        }
    }

    public void tick() {
        if (this.isAlive()) {
            this.oldSwell = this.swell;
            int i = this.getSwellDir();
            if (i > 0 && this.swell == 0) {
                this.playSound(SoundEvents.CREEPER_PRIMED, 1.0F, 0.5F);
                this.gameEvent(GameEvent.PRIME_FUSE);
            }

            this.swell += i;
            if (this.swell < 0) {
                this.swell = 0;
            }

            if (this.swell >= this.maxSwell) {
                this.swell = this.maxSwell;
                this.explode();
            }
        }

        super.tick();
    }

    public void setTarget(@Nullable LivingEntity livingEntity) {
        if (!(livingEntity instanceof Goat)) {
            super.setTarget(livingEntity);
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.CREEPER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.CREEPER_DEATH;
    }

    public boolean doHurtTarget(Entity entity) {
        return true;
    }

    public float getSwelling(float f) {
        return Mth.lerp(f, (float)this.oldSwell, (float)this.swell) / (float)(this.maxSwell - 2);
    }

    public int getSwellDir() {
        return this.entityData.get(DATA_SWELL_DIR);
    }

    public void setSwellDir(int i) {
        this.entityData.set(DATA_SWELL_DIR, i);
    }

    protected void explode() {
        this.playSound(SoundEvents.GENERIC_EXPLODE);
        if (!this.level.isClientSide) {
            this.dead = true;
            this.discard();
            this.spawnLingeringCloud();
        }
    }

    protected void spawnLingeringCloud() {
        AreaEffectCloud areaEffectCloud = new AreaEffectCloud(this.level, this.getX(), this.getY(), this.getZ());
        areaEffectCloud.setRadius(5.0F);
        areaEffectCloud.setRadiusOnUse(-0.5F);
        areaEffectCloud.setWaitTime(10);
        areaEffectCloud.setDuration(areaEffectCloud.getDuration() / 2);
        areaEffectCloud.setRadiusPerTick(-areaEffectCloud.getRadius() / (float)areaEffectCloud.getDuration());
        areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200));
        areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.POISON, 200));
        areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200));
        this.level.addFreshEntity(areaEffectCloud);
    }

    static {
        DATA_SWELL_DIR = SynchedEntityData.defineId(GymbagEntity.class, EntityDataSerializers.INT);
    }

    static class GymbagSwellGoal extends Goal {
        private final GymbagEntity gymbag;
        @Nullable
        private LivingEntity target;

        public GymbagSwellGoal(GymbagEntity gymbag) {
            this.gymbag = gymbag;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            LivingEntity livingEntity = this.gymbag.getTarget();
            return this.gymbag.getSwellDir() > 0 || livingEntity != null && this.gymbag.distanceToSqr(livingEntity) < 9.0;
        }

        public void start() {
            this.gymbag.getNavigation().stop();
            this.target = this.gymbag.getTarget();
        }

        public void stop() {
            this.target = null;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            if (this.target == null) {
                this.gymbag.setSwellDir(-1);
            } else if (this.gymbag.distanceToSqr(this.target) > 49.0) {
                this.gymbag.setSwellDir(-1);
            } else if (!this.gymbag.getSensing().hasLineOfSight(this.target)) {
                this.gymbag.setSwellDir(-1);
            } else {
                this.gymbag.setSwellDir(1);
            }
        }
    }
}
