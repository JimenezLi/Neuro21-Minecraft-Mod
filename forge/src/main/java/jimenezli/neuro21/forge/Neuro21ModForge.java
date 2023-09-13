package jimenezli.neuro21.forge;

import dev.architectury.platform.forge.EventBuses;
import jimenezli.neuro21.ModEntityTypes;
import jimenezli.neuro21.ModItems;
import jimenezli.neuro21.Neuro21Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Neuro21Mod.MOD_ID)
public class Neuro21ModForge {
    public Neuro21ModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Neuro21Mod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        ModEntityTypes.register(null);
        ModItems.register(null);
    }
}