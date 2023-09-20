package jimenezli.neuro21.mixin;

import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Skeleton.class)
public class SkeletonLootMixin extends Mob {
    protected SkeletonLootMixin(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(at = @At("TAIL"), method = "dropCustomDeathLoot")
    private void Init(DamageSource damageSource, int i, boolean bl, CallbackInfo ci) {
        if (damageSource.getEntity() instanceof Creeper && this.random.nextDouble() < 0.1D) {
            ItemStack itemStack = new ItemStack(ItemHandler.LIVING_MILLENNIUM.get());
            this.spawnAtLocation(itemStack);
        }
    }
}
