package jimenezli.neuro21.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import jimenezli.neuro21.Neuro21Mod;
import jimenezli.neuro21.client.model.NeurosamaModel;
import jimenezli.neuro21.entity.HiyoriEntity;
import jimenezli.neuro21.entity.NeurosamaEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

import static jimenezli.neuro21.Neuro21Mod.prefix;

public class NeurosamaRenderer extends HumanoidMobRenderer<NeurosamaEntity, NeurosamaModel<NeurosamaEntity>> {
    private static final ResourceLocation NEUROSAMA = prefix("textures/entity/neurosama.png");
    private static final ResourceLocation EVIL_NEUROSAMA = prefix("textures/entity/evil_neurosama.png");
    private static final ResourceLocation HIYORI = prefix("textures/entity/hiyori.png");
    private static final ResourceLocation HIYORI_ABANDONED = prefix("textures/entity/hiyori_abandoned.png");

    public NeurosamaRenderer(EntityRendererProvider.Context context) {
        super(context, new NeurosamaModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM), true), 0.5F);
        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM_INNER_ARMOR)), new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM_OUTER_ARMOR))));
    }

    /**
     * If named jeb_ or name contains "RGB", then Neuro-sama becomes RGB-sama.
     */
    public void render(NeurosamaEntity neurosama, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        if (neurosama.hasCustomName()) {
            String name = neurosama.getName().getString();
            if ("jeb_".equals(name) || name.toLowerCase().contains("rgb")) {
                // HSV to RGB conversion
                int H = (neurosama.tickCount + neurosama.getId()) * 2 % 360;
                int I = H / 60;
                float C = ((float) H) / 60.0F - I;
                float R, G, B;
                switch (I) {
                    case 0  -> { R = 1.0F;     G = C;        B = 0.0F;     }
                    case 1  -> { R = 1.0F - C; G = 1.0F;     B = 0.0F;     }
                    case 2  -> { R = 0.0F;     G = 1.0F;     B = C;        }
                    case 3  -> { R = 0.0F;     G = 1.0F - C; B = 1.0F;     }
                    case 4  -> { R = C;        G = 0.0F;     B = 1.0F;     }
                    default -> { R = 1.0F;     G = 0.0F;     B = 1.0F - C; }
                }
                this.model.setColor(R * 0.6F + 0.4F, G * 0.6F + 0.4F, B * 0.6F + 0.4F);
            }
        }
        super.render(neurosama, f, g, poseStack, multiBufferSource, i);
        this.model.setColor(1.0F, 1.0F, 1.0F); // Reset color every time
    }

    @Override
    public ResourceLocation getTextureLocation(NeurosamaEntity neurosama) {
        return switch (neurosama.getNeurosamaType()) {
            case EVIL_NEUROSAMA -> EVIL_NEUROSAMA;
            case HIYORI -> neurosama.isAbandoned() ? HIYORI_ABANDONED : HIYORI;
            default -> NEUROSAMA;
        };
    }
}
