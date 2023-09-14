package jimenezli.neuro21.client.renderer.entity;

import jimenezli.neuro21.Neuro21Mod;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.TurtleRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Turtle;

public class VedalRenderer extends TurtleRenderer {
    private static final ResourceLocation VEDAL = new ResourceLocation(Neuro21Mod.MOD_ID, "textures/entity/vedal.png");

    public VedalRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Turtle turtle) {
        return VEDAL;
    }
}
