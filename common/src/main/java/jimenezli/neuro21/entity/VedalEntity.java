package jimenezli.neuro21.entity;

import jimenezli.neuro21.entity.ai.goal.NeurosamaFamilyHurtByTargetGoal;
import jimenezli.neuro21.handler.ItemHandler;
import jimenezli.neuro21.util.NeurosamaType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class VedalEntity extends Turtle {
    public VedalEntity(EntityType<? extends Turtle> entityType, Level level) {
        super(entityType, level);
    }

    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D, AnnyEntity.class));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.addGoal(1, new NeurosamaFamilyHurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Turtle.createAttributes().add(Attributes.ATTACK_DAMAGE, 1.0D);
    }

    /**
     * Vedal won't drop any xp in case someone kills him on purpose.
     */
    public boolean shouldDropExperience() {
        return false;
    }

    /**
     * Vedal won't drop any loot in case someone kills him on purpose.
     */
    protected boolean shouldDropLoot() {
        return false;
    }

    public boolean isFood(ItemStack itemStack) {
        return super.isFood(itemStack) || itemStack.getItem() == ItemHandler.HEART.get();
    }

    public boolean canMate(Animal animal) {
        if (animal.getClass() != AnnyEntity.class) {
            return false;
        } else {
            return this.isInLove() && animal.isInLove();
        }
    }

    public NeurosamaEntity getBreedOffspring(ServerLevel world, AgeableMob ageable) {
        NeurosamaType type = (this.random.nextDouble() < 0.9) ? NeurosamaType.NEUROSAMA : NeurosamaType.EVIL_NEUROSAMA;
        return NeurosamaType.getNeurosama(type).create(world);
    }
}
