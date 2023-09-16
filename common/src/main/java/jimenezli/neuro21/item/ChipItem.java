package jimenezli.neuro21.item;

import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChipItem extends Item {
    public ChipItem() {
        super(ItemHandler.defaultBuilder());
    }

    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable("item.neuro21.chip.desc").withStyle(ChatFormatting.GRAY));
    }
}
