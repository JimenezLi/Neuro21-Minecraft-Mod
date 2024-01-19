package jimenezli.neuro21.item;

import jimenezli.neuro21.handler.EntityHandler;
import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UpgradeChipItem extends Item {
    public UpgradeChipItem() {
        super(ItemHandler.defaultBuilder());
    }

    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (livingEntity.getClass() == Turtle.class) {
            if (!player.level.isClientSide && livingEntity.isAlive()) {
                ((Turtle) livingEntity).convertTo(EntityHandler.VEDAL.get(), true);
                itemStack.shrink(1);
            }
            return InteractionResult.sidedSuccess(player.level.isClientSide);
        } else if (livingEntity.getClass() == Fox.class) {
            if (!player.level.isClientSide && livingEntity.isAlive()) {
                ((Fox) livingEntity).convertTo(EntityHandler.ANNY.get(), true);
                itemStack.shrink(1);
            }
            return InteractionResult.sidedSuccess(player.level.isClientSide);
        } else if (livingEntity.getClass() == Cow.class) {
            player.displayClientMessage(Component.translatable("entity.neuro21.iron_cow.pass"), true);
            return InteractionResult.PASS;
        } else {
            return InteractionResult.PASS;
        }
    }

    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable("item.neuro21.upgrade_chip.desc").withStyle(ChatFormatting.GRAY));
    }
}
