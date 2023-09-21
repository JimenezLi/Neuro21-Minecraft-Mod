package jimenezli.neuro21.client;

import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import jimenezli.neuro21.client.renderer.entity.AnnyRenderer;
import jimenezli.neuro21.client.renderer.entity.IronCowRenderer;
import jimenezli.neuro21.client.renderer.entity.NeurosamaRenderer;
import jimenezli.neuro21.client.renderer.entity.VedalRenderer;
import jimenezli.neuro21.handler.BlockHandler;
import jimenezli.neuro21.handler.EntityHandler;
import net.minecraft.client.renderer.RenderType;

public class Neuro21ModClient {
    public static void preInit() {
        EntityRendererRegistry.register(EntityHandler.VEDAL, VedalRenderer::new);
        EntityRendererRegistry.register(EntityHandler.ANNY, AnnyRenderer::new);
        EntityRendererRegistry.register(EntityHandler.NEUROSAMA, NeurosamaRenderer::new);
        EntityRendererRegistry.register(EntityHandler.EVIL_NEUROSAMA, NeurosamaRenderer::new);
        EntityRendererRegistry.register(EntityHandler.HIYORI, NeurosamaRenderer::new);
        EntityRendererRegistry.register(EntityHandler.IRON_COW, IronCowRenderer::new);
    }

    public static void Init() {
        RenderTypeRegistry.register(RenderType.cutout(), BlockHandler.CHINESE_CABBAGE_BLOCK.get());
    }
}
