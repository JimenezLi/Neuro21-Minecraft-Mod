package jimenezli.neuro21.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import jimenezli.neuro21.client.model.NeurosamaModel;
import jimenezli.neuro21.entity.boss.hiyori.HiyoriBossEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

import static jimenezli.neuro21.Neuro21Mod.prefix;
import static jimenezli.neuro21.util.Parameters.hiyoriBossScale;

public class HiyoriBossRenderer extends HumanoidMobRenderer<HiyoriBossEntity, PlayerModel<HiyoriBossEntity>> {
    private static final ResourceLocation HIYORI_BOSS = prefix("textures/entity/hiyori_boss.png");

    public HiyoriBossRenderer(EntityRendererProvider.Context context) {
        super(context, new NeurosamaModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM), true), 0.5F);
        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM_INNER_ARMOR)), new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM_OUTER_ARMOR))));
    }

    @Override
    protected void scale(HiyoriBossEntity livingEntity, PoseStack poseStack, float f) {
        super.scale(livingEntity, poseStack, f);
        poseStack.scale(hiyoriBossScale, hiyoriBossScale, hiyoriBossScale);
    }

    public ResourceLocation getTextureLocation(HiyoriBossEntity hiyoriBoss) {
        return HIYORI_BOSS;
    }
}
