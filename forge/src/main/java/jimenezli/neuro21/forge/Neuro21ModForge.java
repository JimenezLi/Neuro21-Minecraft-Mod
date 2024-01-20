package jimenezli.neuro21.forge;

import dev.architectury.platform.Platform;
import dev.architectury.platform.forge.EventBuses;
import jimenezli.neuro21.Neuro21Mod;
import jimenezli.neuro21.client.Neuro21ModClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Neuro21Mod.MOD_ID)
public class Neuro21ModForge {
    public Neuro21ModForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(Neuro21Mod.MOD_ID, bus);
        Neuro21Mod.preInit();

        if (Platform.getEnv().isClient()) {
            Neuro21ModClient.preInit();
        }

        bus.addListener(this::clientSetup);
        bus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        Neuro21ModClient.Init();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(Neuro21Mod::Init);
    }
}
