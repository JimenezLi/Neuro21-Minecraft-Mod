package jimenezli.neuro21.mixin;

import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Zombie.class)
public class ZombieLootMixin extends Mob {
    protected ZombieLootMixin(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    // I don't know how to modify loot table
    @Inject(at = @At("TAIL"), method = "dropCustomDeathLoot")
    private void Init(DamageSource damageSource, int i, boolean bl, CallbackInfo ci) {
        if (damageSource.getEntity() instanceof Player) {
            if (this.random.nextDouble() < 0.1D) {
                ItemStack itemStack = new ItemStack(ItemHandler.CHIP.get());
                this.spawnAtLocation(itemStack);
            }
            if (this.random.nextDouble() < 0.025D) {
                ItemStack itemStack = new ItemStack(ItemHandler.CHINESE_CABBAGE.get());
                this.spawnAtLocation(itemStack);
            }
        }
    }
}
