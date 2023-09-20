package jimenezli.neuro21.client;

import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import jimenezli.neuro21.handler.BlockHandler;
import net.minecraft.client.renderer.RenderType;

public class Neuro21ModClient {
    public static void init() {
        // EntityRenderer method crash on Forge, so I have to register entity renderer on both sides
        RenderTypeRegistry.register(RenderType.cutout(), BlockHandler.CHINESE_CABBAGE_BLOCK.get());
    }
}
