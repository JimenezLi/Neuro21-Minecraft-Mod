package jimenezli.neuro21.entity;

import jimenezli.neuro21.ModEntityTypes;
import jimenezli.neuro21.ModItems;
import jimenezli.neuro21.entity.ai.goal.NeurosamaFamilyHurtByTargetGoal;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.PathComputationType;
import org.jetbrains.annotations.Nullable;

public class NeurosamaEntity extends Animal {
    private int heartTime = this.random.nextInt(6000) + 6000;

    protected NeurosamaType neurosamaType = NeurosamaType.NEUROSAMA;

    public NeurosamaType getNeurosamaType() {
        return this.neurosamaType;
    }

    public NeurosamaEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    protected void registerGoals() {
        this.registerCustomGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D, 60));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Turtle.class, 8.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Fox.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NeurosamaFamilyHurtByTargetGoal(this));
    }

    protected void registerCustomGoals() {
        this.goalSelector.addGoal(1, new MoveToLavaGoal(this, 4.0D));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 1.0D).add(Attributes.MOVEMENT_SPEED, 0.3).add(Attributes.MAX_HEALTH, 20.0);
    }

    /**
     * Neurosama produces heart like chicken produces egg.
     */
    public void aiStep() {
        super.aiStep();

        if (!this.level.isClientSide && this.isAlive() && !this.isBaby() && --this.heartTime <= 0) {
            this.spawnAtLocation(ModItems.getHeartItem());
            this.heartTime = this.random.nextInt(6000) + 6000;
        }
    }

    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("HeartProductionTime")) {
            this.heartTime = compoundTag.getInt("HeartProductionTime");
        }
    }

    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("HeartProductionTime", this.heartTime);
    }

    /**
     * Neuro-sama won't drop any experience in case someone kills her on purpose.
     */
    public boolean shouldDropExperience() {
        return false;
    }

    /**
     * Neuro-sama won't drop any loot in case someone kills her on purpose.
     */
    protected boolean shouldDropLoot() {
        return false;
    }

    public boolean isFood(ItemStack itemStack) {
        return itemStack.getItem() == ModItems.getHeartItem();
    }

    public boolean canMate(Animal animal) {
        if (animal == this) {
            return false;
        } else if (!(animal instanceof NeurosamaEntity)) {
            return false;
        } else {
            return this.isInLove() && animal.isInLove();
        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        NeurosamaType type = this.neurosamaType;
        if (ageableMob instanceof NeurosamaEntity) {
            if (this.neurosamaType != ((NeurosamaEntity) ageableMob).neurosamaType) {
                if (this.random.nextDouble() < 0.1) {
                    type = NeurosamaType.HIYORI;
                } else {
                    type = (this.random.nextDouble() < 0.5) ? this.neurosamaType : ((NeurosamaEntity) ageableMob).neurosamaType;
                }
            }
        }
        return ModEntityTypes.getNeurosamaEntity(type).create(serverLevel);
    }

    /**
     * This MoveToLavaGoal is copied from strider.
     */
    static class MoveToLavaGoal extends MoveToBlockGoal {
        private final NeurosamaEntity neurosama;

        private MoveToLavaGoal(NeurosamaEntity neurosama, double d) {
            super(neurosama, d, 8, 2);
            this.neurosama = neurosama;
        }

        public BlockPos getMoveToTarget() {
            return this.blockPos;
        }

        public boolean canContinueToUse() {
            return !this.neurosama.isInLava() && this.isValidTarget(this.neurosama.level, this.blockPos);
        }

        public boolean canUse() {
            return !this.neurosama.isInLava() && super.canUse();
        }

        public boolean shouldRecalculatePath() {
            return this.tryTicks % 20 == 0;
        }

        @Override
        protected boolean isValidTarget(LevelReader levelReader, BlockPos blockPos) {
            return levelReader.getBlockState(blockPos).is(Blocks.LAVA) && levelReader.getBlockState(blockPos.above()).isPathfindable(levelReader, blockPos, PathComputationType.LAND);
        }
    }
}
