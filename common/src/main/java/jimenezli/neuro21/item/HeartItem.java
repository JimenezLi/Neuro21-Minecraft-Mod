package jimenezli.neuro21.item;

import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HeartItem extends Item {
    public static final FoodProperties HEART_FOOD = (new FoodProperties.Builder())
            .nutrition(1)
            .saturationMod(0.1F)
            .alwaysEat()
            .build();

    public HeartItem() {
        super(ItemHandler.defaultBuilder().food(HEART_FOOD));
    }

    /**
     * When the heart is consumed, it levels up player's current absorption effect (max level is 5).
     * Isn't it too overpowered?
     */
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        ItemStack resultItemStack = super.finishUsingItem(itemStack, level, livingEntity);

        MobEffectInstance absorption = livingEntity.getEffect(MobEffects.ABSORPTION);
        if (absorption != null) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, Math.min(absorption.getAmplifier() + 1, 4)));
        } else {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200));
        }

        return resultItemStack;
    }
}
