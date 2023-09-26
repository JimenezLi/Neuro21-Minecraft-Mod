package jimenezli.neuro21.client.renderer.entity;

import jimenezli.neuro21.client.model.SwarmDroneModel;
import jimenezli.neuro21.client.model.geom.Neuro21ModelLayers;
import jimenezli.neuro21.entity.boss.hiyori.SwarmDroneEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static jimenezli.neuro21.Neuro21Mod.prefix;

public class SwarmDroneRenderer extends MobRenderer<SwarmDroneEntity, SwarmDroneModel<SwarmDroneEntity>> {
    private static final ResourceLocation SWARM_DRONE = prefix("textures/entity/swarm_drone.png");

    public SwarmDroneRenderer(EntityRendererProvider.Context context) {
        super(context, new SwarmDroneModel<>(context.bakeLayer(Neuro21ModelLayers.SWARM_DRONE)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SwarmDroneEntity entity) {
        return SWARM_DRONE;
    }
}
