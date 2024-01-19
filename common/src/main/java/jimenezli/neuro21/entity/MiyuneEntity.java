package jimenezli.neuro21.entity;

import jimenezli.neuro21.entity.ai.goal.MiyuneFollowNeurosamaGoal;
import jimenezli.neuro21.entity.ai.goal.NeurosamaFamilyHurtByTargetGoal;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class MiyuneEntity extends Animal {
    public MiyuneEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new MiyuneFollowNeurosamaGoal(this, 1.25));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D, 60));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NeurosamaFamilyHurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3).add(Attributes.MAX_HEALTH, 20.0);
    }

    /**
     * Miyune won't drop any experience in case someone kills her on purpose.
     */
    public boolean shouldDropExperience() {
        return false;
    }

    /**
     * Miyune won't drop any loot in case someone kills her on purpose.
     */
    protected boolean shouldDropLoot() {
        return false;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }
}
