package jimenezli.neuro21.mixin;

import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Pig.class)
public class ChineseCabbageIsPigFoodMixin {
    @Inject(method = "isFood", at = @At("RETURN"), cancellable = true)
    private void Init(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        if (itemStack.is(ItemHandler.CHINESE_CABBAGE.get())) {
            cir.setReturnValue(true);
        }
    }
}
