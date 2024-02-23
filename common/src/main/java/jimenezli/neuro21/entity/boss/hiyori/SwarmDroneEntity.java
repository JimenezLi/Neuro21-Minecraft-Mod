package jimenezli.neuro21.entity.boss.hiyori;

import jimenezli.neuro21.handler.SoundHandler;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.List;

public class SwarmDroneEntity extends Monster {
    public SwarmDroneEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new FlyingMoveControl(this, 10, true);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation flyingPathNavigation = new FlyingPathNavigation(this, level);
        flyingPathNavigation.setCanFloat(true);
        return flyingPathNavigation;
    }

    public boolean causeFallDamage(float f, float g, DamageSource damageSource) {
        return false;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 10).add(Attributes.MOVEMENT_SPEED, 1.0).add(Attributes.FLYING_SPEED, 1.0).add(Attributes.FOLLOW_RANGE, 32).add(Attributes.ATTACK_DAMAGE, 4.0);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.BEE_LOOP;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ANVIL_PLACE;
    }

    protected SoundEvent getDeathSound() {
        return SoundHandler.EXPLOSION.getOrNull();
    }

    public double getPassengersRidingOffset() {
        return -(double)this.getType().getDimensions().height * 0.5D;
    }

    /**
     * Swarm Drone can catch wolf, which is Neuro's dogcopter project
     */
    public void aiStep() {
        super.aiStep();
        if (!this.level.isClientSide && this.isAlive()) {
            if (this.getPassengers().isEmpty()) {
                List<Entity> nearbyEntities = this.level.getEntities(this, this.getBoundingBox().inflate(2.0, 1.0, 2.0));
                for (Entity entity : nearbyEntities) {
                    if ((entity instanceof Wolf) && entity.getVehicle() == null) {
                        entity.startRiding(this);
                        break;
                    }
                }
            }
        }
    }

    public void tick() {
        super.tick();
        this.setNoGravity(true);
    }
}
