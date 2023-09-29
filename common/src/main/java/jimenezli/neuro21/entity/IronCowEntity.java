package jimenezli.neuro21.entity;

import jimenezli.neuro21.entity.ai.goal.NeurosamaFamilyHurtByTargetGoal;
import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class IronCowEntity extends Cow {
    private int nextMilkTicks;
    private static final EntityDataAccessor<Integer> DATA_NEXT_MILK_TICKS;

    /**
     * I didn't override the breed method so iron cow's offsprings are normal cows.
     */
    public IronCowEntity(EntityType<? extends Cow> entityType, Level level) {
        super(entityType, level);
        this.nextMilkTicks = 0;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_NEXT_MILK_TICKS, 0);
    }

    static {
        DATA_NEXT_MILK_TICKS = SynchedEntityData.defineId(IronCowEntity.class, EntityDataSerializers.INT);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0).add(Attributes.MOVEMENT_SPEED, 0.2);
    }

    /**
     * Warning! if you attack the cow, the Neuro-sama family will attack you!
     */
    public void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, new NeurosamaFamilyHurtByTargetGoal(this));
    }

    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("NextMilkTicks")) {
            this.nextMilkTicks = compoundTag.getInt("NextMilkTicks");
        }
    }

    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("NextMilkTicks", this.nextMilkTicks);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    public void aiStep() {
        super.aiStep();
        if (!this.level.isClientSide && this.isAlive() && !this.isBaby()) {
            this.entityData.set(DATA_NEXT_MILK_TICKS, --nextMilkTicks);
        }
    }

    public InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.is(Items.BUCKET) && !this.isBaby()) {
            if (this.entityData.get(DATA_NEXT_MILK_TICKS) < 0) {
                if (!this.level.isClientSide) {
                    nextMilkTicks = 6000;
                } else {
                    this.entityData.set(DATA_NEXT_MILK_TICKS, 6000);
                }
                player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
                ItemStack itemStack2 = ItemUtils.createFilledResult(itemStack, player, new ItemStack(ItemHandler.IRONMILK.get()));
                player.setItemInHand(interactionHand, itemStack2);
                return InteractionResult.sidedSuccess(this.level.isClientSide);
            } else {
                player.displayClientMessage(Component.translatable("entity.neuro21.iron_cow.cooldown", Integer.valueOf(this.entityData.get(DATA_NEXT_MILK_TICKS) / 1200 + 1).toString()), true);
                return InteractionResult.PASS;
            }
        }
        return super.mobInteract(player, interactionHand);
    }
}
