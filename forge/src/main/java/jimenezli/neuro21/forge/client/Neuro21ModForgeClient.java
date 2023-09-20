package jimenezli.neuro21.forge.client;

import jimenezli.neuro21.Neuro21Mod;
import jimenezli.neuro21.client.Neuro21ModClient;
import jimenezli.neuro21.client.renderer.entity.AnnyRenderer;
import jimenezli.neuro21.client.renderer.entity.IronCowRenderer;
import jimenezli.neuro21.client.renderer.entity.NeurosamaRenderer;
import jimenezli.neuro21.client.renderer.entity.VedalRenderer;
import jimenezli.neuro21.handler.EntityHandler;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD, modid = Neuro21Mod.MOD_ID)
public class Neuro21ModForgeClient {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        Neuro21ModClient.init();
        EntityRenderers.register(EntityHandler.VEDAL.get(), VedalRenderer::new);
        EntityRenderers.register(EntityHandler.ANNY.get(), AnnyRenderer::new);
        EntityRenderers.register(EntityHandler.NEUROSAMA.get(), NeurosamaRenderer::new);
        EntityRenderers.register(EntityHandler.EVIL_NEUROSAMA.get(), NeurosamaRenderer::new);
        EntityRenderers.register(EntityHandler.HIYORI.get(), NeurosamaRenderer::new);
        EntityRenderers.register(EntityHandler.IRON_COW.get(), IronCowRenderer::new);
    }
}
