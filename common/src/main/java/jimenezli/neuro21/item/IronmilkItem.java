package jimenezli.neuro21.item;

import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.level.Level;

public class IronmilkItem extends MilkBucketItem {
    public IronmilkItem() {
        super(ItemHandler.defaultBuilder().stacksTo(1));
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, itemStack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (livingEntity instanceof Player && !((Player)livingEntity).getAbilities().instabuild) {
            itemStack.shrink(1);
        }

        if (!level.isClientSide) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 3));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3600));
        }

        return itemStack.isEmpty() ? new ItemStack(Items.BUCKET) : itemStack;
    }
}
