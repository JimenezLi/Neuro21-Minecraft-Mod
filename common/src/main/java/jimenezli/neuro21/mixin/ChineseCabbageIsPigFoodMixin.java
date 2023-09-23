package jimenezli.neuro21.mixin;

import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Pig.class)
public class ChineseCabbageIsPigFoodMixin extends PathfinderMob {
    protected ChineseCabbageIsPigFoodMixin(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "isFood", at = @At("RETURN"), cancellable = true)
    private void isFoodInjector(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        if (itemStack.is(ItemHandler.CHINESE_CABBAGE.get())) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "registerGoals", at = @At("TAIL"))
    private void registerGoalsInjector(CallbackInfo info) {
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2, Ingredient.of(ItemHandler.CHINESE_CABBAGE.get()), false));
    }
}
