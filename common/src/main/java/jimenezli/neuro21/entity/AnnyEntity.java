package jimenezli.neuro21.entity;

import jimenezli.neuro21.entity.ai.goal.NeurosamaFamilyHurtByTargetGoal;
import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AnnyEntity extends Fox {
    private static final EntityDataAccessor<Boolean> DATA_IMMUNE;

    public AnnyEntity(EntityType<? extends Fox> entityType, Level level) {
        super(entityType, level);
    }

    static {
        DATA_IMMUNE = SynchedEntityData.defineId(AnnyEntity.class, EntityDataSerializers.BOOLEAN);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_IMMUNE, false);
    }

    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D, VedalEntity.class));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.addGoal(1, new NeurosamaFamilyHurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Fox.createAttributes();
    }

    /**
     * Anny won't drop any xp in case someone kills her on purpose.
     */
    public boolean shouldDropExperience() {
        return false;
    }

    /**
     * Anny won't drop any loot in case someone kills her on purpose.
     */
    protected boolean shouldDropLoot() {
        return false;
    }

    public boolean isFood(ItemStack itemStack) {
        return super.isFood(itemStack) || itemStack.getItem() == ItemHandler.HEART.get();
    }

    /**
     * Anny becomes immune to negative effects once she recovers from it.
     */
    public boolean hurt(DamageSource damageSource, float f) {
        if (damageSource.isMagic() && this.isImmuneToNegativeEffect()) {
            return false;
        }
        return super.hurt(damageSource, f);
    }

    /**
     * Anny becomes immune to negative effects once she recovers from it.
     */
    public boolean canBeAffected(MobEffectInstance mobEffectInstance) {
        if (mobEffectInstance.getEffect().getCategory() == MobEffectCategory.HARMFUL) {
            return !this.isImmuneToNegativeEffect();
        }
        return super.canBeAffected(mobEffectInstance);
    }

    /**
     * Anny becomes immune to negative effects once she recovers from it.
     */
    protected void onEffectRemoved(MobEffectInstance mobEffectInstance) {
        super.onEffectRemoved(mobEffectInstance);
        if (mobEffectInstance.getEffect().getCategory() == MobEffectCategory.HARMFUL) {
            this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200));
            this.entityData.set(DATA_IMMUNE, true);
        }
    }

    public boolean isImmuneToNegativeEffect() {
        return this.entityData.get(DATA_IMMUNE);
    }

    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("ImmuneToNegativeEffect")) {
            this.entityData.set(DATA_IMMUNE, compoundTag.getBoolean("ImmuneToNegativeEffect"));
        }
    }

    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("ImmuneToNegativeEffect", this.entityData.get(DATA_IMMUNE));
    }

    public boolean canMate(Animal animal) {
        if (animal.getClass() != VedalEntity.class) {
            return false;
        } else {
            return this.isInLove() && animal.isInLove();
        }
    }

    public Fox getBreedOffspring(ServerLevel world, AgeableMob ageable) {
        return null;
    }
}
