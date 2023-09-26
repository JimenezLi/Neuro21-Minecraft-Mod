package jimenezli.neuro21.client;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import jimenezli.neuro21.client.model.GymbagModel;
import jimenezli.neuro21.client.model.SwarmDroneModel;
import jimenezli.neuro21.client.model.geom.Neuro21ModelLayers;
import jimenezli.neuro21.client.renderer.entity.*;
import jimenezli.neuro21.client.renderer.entity.HiyoriBossRenderer;
import jimenezli.neuro21.handler.BlockHandler;
import jimenezli.neuro21.handler.EntityHandler;
import net.minecraft.client.renderer.RenderType;

public class Neuro21ModClient {
    public static void preInit() {
        EntityModelLayerRegistry.register(Neuro21ModelLayers.GYMBAG, GymbagModel::createBodyLayer);
        EntityModelLayerRegistry.register(Neuro21ModelLayers.SWARM_DRONE, SwarmDroneModel::createBodyLayer);

        EntityRendererRegistry.register(EntityHandler.VEDAL, VedalRenderer::new);
        EntityRendererRegistry.register(EntityHandler.ANNY, AnnyRenderer::new);
        EntityRendererRegistry.register(EntityHandler.NEUROSAMA, NeurosamaRenderer::new);
        EntityRendererRegistry.register(EntityHandler.EVIL_NEUROSAMA, NeurosamaRenderer::new);
        EntityRendererRegistry.register(EntityHandler.HIYORI, NeurosamaRenderer::new);
        EntityRendererRegistry.register(EntityHandler.IRON_COW, IronCowRenderer::new);
        EntityRendererRegistry.register(EntityHandler.HIYORI_BOSS, HiyoriBossRenderer::new);
        EntityRendererRegistry.register(EntityHandler.GYMBAG, GymbagRenderer::new);
        EntityRendererRegistry.register(EntityHandler.SWARM_DRONE, SwarmDroneRenderer::new);
    }

    public static void Init() {
        RenderTypeRegistry.register(RenderType.cutout(), BlockHandler.CHINESE_CABBAGE_BLOCK.get());
    }
}
