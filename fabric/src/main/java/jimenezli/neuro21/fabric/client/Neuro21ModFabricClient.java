package jimenezli.neuro21.fabric.client;

import jimenezli.neuro21.client.Neuro21ModClient;
import jimenezli.neuro21.client.renderer.entity.AnnyRenderer;
import jimenezli.neuro21.client.renderer.entity.IronCowRenderer;
import jimenezli.neuro21.client.renderer.entity.NeurosamaRenderer;
import jimenezli.neuro21.client.renderer.entity.VedalRenderer;
import jimenezli.neuro21.handler.EntityHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class Neuro21ModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Neuro21ModClient.init();
        EntityRendererRegistry.register(EntityHandler.VEDAL.get(), VedalRenderer::new);
        EntityRendererRegistry.register(EntityHandler.ANNY.get(), AnnyRenderer::new);
        EntityRendererRegistry.register(EntityHandler.NEUROSAMA.get(), NeurosamaRenderer::new);
        EntityRendererRegistry.register(EntityHandler.EVIL_NEUROSAMA.get(), NeurosamaRenderer::new);
        EntityRendererRegistry.register(EntityHandler.HIYORI.get(), NeurosamaRenderer::new);
        EntityRendererRegistry.register(EntityHandler.IRON_COW.get(), IronCowRenderer::new);
    }
}
