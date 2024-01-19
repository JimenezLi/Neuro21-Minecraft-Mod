package jimenezli.neuro21.client.renderer.entity;

import jimenezli.neuro21.entity.GigaVedalEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

import static jimenezli.neuro21.Neuro21Mod.prefix;

public class GigaVedalRenderer extends HumanoidMobRenderer<GigaVedalEntity, PlayerModel<GigaVedalEntity>> {
    private static final ResourceLocation GIGA_VEDAL = prefix("textures/entity/giga_vedal.png");

    public GigaVedalRenderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER), false), 0.5F);
        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
    }

    @Override
    public ResourceLocation getTextureLocation(GigaVedalEntity gigaVedal) {
        return GIGA_VEDAL;
    }
}
