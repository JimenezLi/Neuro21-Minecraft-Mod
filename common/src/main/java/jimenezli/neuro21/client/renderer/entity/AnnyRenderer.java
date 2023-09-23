package jimenezli.neuro21.client.renderer.entity;

import jimenezli.neuro21.Neuro21Mod;
import jimenezli.neuro21.entity.AnnyEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.FoxRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Fox;

public class AnnyRenderer extends FoxRenderer {
    private static final ResourceLocation ANNY = new ResourceLocation(Neuro21Mod.MOD_ID, "textures/entity/anny.png");
    private static final ResourceLocation ANNY_SLEEP = new ResourceLocation(Neuro21Mod.MOD_ID, "textures/entity/anny_sleep.png");
    private static final ResourceLocation ANNY_IMMUNE = new ResourceLocation(Neuro21Mod.MOD_ID, "textures/entity/anny_immune.png");

    public AnnyRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    public ResourceLocation getTextureLocation(Fox fox) {
        return fox.isSleeping() ? ANNY_SLEEP : ((AnnyEntity) fox).isImmuneToNegativeEffect() ? ANNY_IMMUNE : ANNY;
    }
}
