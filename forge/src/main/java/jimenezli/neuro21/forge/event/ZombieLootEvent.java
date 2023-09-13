package jimenezli.neuro21.forge.event;

import jimenezli.neuro21.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ZombieLootEvent {
    @SubscribeEvent
    public static void onZombieDrop(LivingDropsEvent event) {
        Entity entity = event.getEntity();
        if (!entity.level.isClientSide() && entity instanceof Zombie) {
            if (event.getSource().getEntity() instanceof Player && ((Zombie) entity).getRandom().nextDouble() < 0.1) {
                event.getDrops().add(new ItemEntity(entity.level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ModItems.getChipItem())));
            }
        }
    }
}
