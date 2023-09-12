package jimenezli.neuro21.fabric.client;

import jimenezli.neuro21.ModEntityTypes;
import jimenezli.neuro21.fabric.ModEntityTypesImpl;
import jimenezli.neuro21.fabric.client.renderer.entity.AnnyRenderer;
import jimenezli.neuro21.fabric.client.renderer.entity.IronCowRenderer;
import jimenezli.neuro21.fabric.client.renderer.entity.NeurosamaRenderer;
import jimenezli.neuro21.fabric.client.renderer.entity.VedalRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class Neuro21ModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntityTypes.getVedalEntity(), VedalRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.getAnnyEntity(), AnnyRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.getNeurosamaEntity(), NeurosamaRenderer::new);
        EntityRendererRegistry.register(ModEntityTypesImpl.IRON_COW, IronCowRenderer::new);
    }
}
