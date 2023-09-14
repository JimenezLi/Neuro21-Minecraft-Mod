package jimenezli.neuro21.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class NeurosamaModel<T extends LivingEntity> extends PlayerModel<T> {
    public NeurosamaModel(ModelPart modelPart, boolean bl) {
        super(modelPart, bl);
    }

    private float r = 1.0F;
    private float g = 1.0F;
    private float b = 1.0F;

    public void setColor(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int j, float f, float g, float h, float k) {
        super.renderToBuffer(poseStack, vertexConsumer, i, j, this.r * f, this.g * g, this.b * h, k);
    }
}
