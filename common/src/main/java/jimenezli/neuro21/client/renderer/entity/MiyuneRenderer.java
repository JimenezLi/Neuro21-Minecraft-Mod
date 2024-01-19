package jimenezli.neuro21.client.renderer.entity;

import jimenezli.neuro21.entity.MiyuneEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

import static jimenezli.neuro21.Neuro21Mod.prefix;

public class MiyuneRenderer extends HumanoidMobRenderer<MiyuneEntity, PlayerModel<MiyuneEntity>> {
    private static final ResourceLocation MIYUNE = prefix("textures/entity/miyune.png");

    public MiyuneRenderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM), true), 0.5F);
        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM_INNER_ARMOR)), new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM_OUTER_ARMOR))));
    }

    @Override
    public ResourceLocation getTextureLocation(MiyuneEntity miyune) {
        return MIYUNE;
    }
}
