package jimenezli.neuro21.client.entity;

import jimenezli.neuro21.Neuro21Mod;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cow;

public class IronCowRenderer extends CowRenderer {
    private static final ResourceLocation IRON_COW = new ResourceLocation(Neuro21Mod.MOD_ID, "textures/entity/iron_cow.png");

    public IronCowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Cow cow) {
        return IRON_COW;
    }
}
