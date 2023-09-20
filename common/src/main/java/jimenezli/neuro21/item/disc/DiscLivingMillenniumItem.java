package jimenezli.neuro21.item.disc;

import jimenezli.neuro21.handler.SoundHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static jimenezli.neuro21.handler.ItemHandler.defaultBuilder;
import static net.minecraft.world.item.Rarity.RARE;

public class DiscLivingMillenniumItem extends RecordItem {
    public DiscLivingMillenniumItem() {
        super(
                0,
                SoundHandler.DISC.getOrNull(),
                defaultBuilder().stacksTo(1).rarity(RARE),
                188
        );
    }

    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);
        list.add(Component.translatable("item.neuro21.music_disc_living_millennium.desc1").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("item.neuro21.music_disc_living_millennium.desc2").withStyle(ChatFormatting.GRAY));
    }
}
