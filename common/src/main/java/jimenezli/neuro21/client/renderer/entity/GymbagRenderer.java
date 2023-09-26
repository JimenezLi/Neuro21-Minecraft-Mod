package jimenezli.neuro21.client.renderer.entity;

import jimenezli.neuro21.client.model.GymbagModel;
import jimenezli.neuro21.client.model.geom.Neuro21ModelLayers;
import jimenezli.neuro21.entity.boss.hiyori.GymbagEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static jimenezli.neuro21.Neuro21Mod.prefix;

public class GymbagRenderer extends MobRenderer<GymbagEntity, GymbagModel<GymbagEntity>> {
    private static final ResourceLocation GYMBAG = prefix("textures/entity/gymbag.png");

    public GymbagRenderer(EntityRendererProvider.Context context) {
        super(context, new GymbagModel<>(context.bakeLayer(Neuro21ModelLayers.GYMBAG)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(GymbagEntity entity) {
        return GYMBAG;
    }
}
