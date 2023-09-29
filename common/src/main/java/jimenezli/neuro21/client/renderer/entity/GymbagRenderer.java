package jimenezli.neuro21.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import jimenezli.neuro21.client.model.GymbagModel;
import jimenezli.neuro21.client.model.geom.Neuro21ModelLayers;
import jimenezli.neuro21.entity.boss.hiyori.GymbagEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static jimenezli.neuro21.Neuro21Mod.prefix;

/**
 * Most of the code is copied from Creeper.
 */
public class GymbagRenderer extends MobRenderer<GymbagEntity, GymbagModel<GymbagEntity>> {
    private static final ResourceLocation GYMBAG = prefix("textures/entity/gymbag.png");

    public GymbagRenderer(EntityRendererProvider.Context context) {
        super(context, new GymbagModel<>(context.bakeLayer(Neuro21ModelLayers.GYMBAG)), 0.5f);
    }

    protected void scale(GymbagEntity gymbag, PoseStack poseStack, float f) {
        float g = gymbag.getSwelling(f);
        float h = 1.0F + Mth.sin(g * 100.0F) * g * 0.01F;
        g = Mth.clamp(g, 0.0F, 1.0F);
        g *= g;
        g *= g;
        float i = (1.0F + g * 0.4F) * h;
        float j = (1.0F + g * 0.1F) / h;
        poseStack.scale(i, j, i);
    }

    protected float getWhiteOverlayProgress(GymbagEntity gymbag, float f) {
        float g = gymbag.getSwelling(f);
        return (int)(g * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(g, 0.5F, 1.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(GymbagEntity entity) {
        return GYMBAG;
    }
}
