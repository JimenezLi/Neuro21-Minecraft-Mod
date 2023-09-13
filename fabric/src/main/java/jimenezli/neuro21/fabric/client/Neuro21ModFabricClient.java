package jimenezli.neuro21.fabric.client;

import jimenezli.neuro21.ModEntityTypes;
import jimenezli.neuro21.client.entity.AnnyRenderer;
import jimenezli.neuro21.client.entity.IronCowRenderer;
import jimenezli.neuro21.client.entity.NeurosamaRenderer;
import jimenezli.neuro21.client.entity.VedalRenderer;
import jimenezli.neuro21.entity.NeurosamaType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class Neuro21ModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntityTypes.getVedalEntity(), VedalRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.getAnnyEntity(), AnnyRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.getNeurosamaEntity(NeurosamaType.NEUROSAMA), NeurosamaRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.getNeurosamaEntity(NeurosamaType.EVIL_NEUROSAMA), NeurosamaRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.getNeurosamaEntity(NeurosamaType.HIYORI), NeurosamaRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.getIronCowEntity(), IronCowRenderer::new);
    }
}
