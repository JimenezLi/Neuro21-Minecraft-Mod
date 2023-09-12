package jimenezli.neuro21.entity;

import jimenezli.neuro21.ModEntityTypes;
import jimenezli.neuro21.ModItems;
import jimenezli.neuro21.entity.ai.goal.NeurosamaFamilyHurtByTargetGoal;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AnnyEntity extends Fox {
    public AnnyEntity(EntityType<? extends Fox> entityType, Level level) {
        super(entityType, level);
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
        return super.isFood(itemStack) || itemStack.getItem() == ModItems.getHeartItem();
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
