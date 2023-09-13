package jimenezli.neuro21.client.entity;

import jimenezli.neuro21.Neuro21Mod;
import jimenezli.neuro21.entity.NeurosamaEntity;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class NeurosamaRenderer extends HumanoidMobRenderer<NeurosamaEntity, PlayerModel<NeurosamaEntity>> {
    private static final ResourceLocation NEUROSAMA = new ResourceLocation(Neuro21Mod.MOD_ID, "textures/entity/neurosama.png");
    private static final ResourceLocation EVIL_NEUROSAMA = new ResourceLocation(Neuro21Mod.MOD_ID, "textures/entity/evil_neurosama.png");
    private static final ResourceLocation HIYORI = new ResourceLocation(Neuro21Mod.MOD_ID, "textures/entity/hiyori.png");

    public NeurosamaRenderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM), true), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(NeurosamaEntity neurosama) {
        return switch (neurosama.getNeurosamaType()) {
            case EVIL_NEUROSAMA -> EVIL_NEUROSAMA;
            case HIYORI -> HIYORI;
            default -> NEUROSAMA;
        };
    }
}
