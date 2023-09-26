package jimenezli.neuro21.client.model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

/**
 * GymbagModel - JimenezLi
 * Created using Tabula 10.5.1 by iChun
 */
public class GymbagModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart root;
    private static final float yRot = (float) Math.PI / 2;
    private static final float zRot = (float) Math.atan(0.25);

    public GymbagModel(ModelPart modelPart) {
        this.root = modelPart;
    }

    @Override
    public void setupAnim(T entity, float f, float g, float h, float i, float j) {
    }

    @Override
    public ModelPart root() {
        return root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition gymbag = partDefinition.addOrReplaceChild("gymbag", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, 12.0F, -8.0F, 12.0F, 12.0F, 16.0F), PartPose.rotation(0.0F, yRot, 0.0F));
        gymbag.addOrReplaceChild("front", CubeListBuilder.create().texOffs(16, 12).addBox(0.0F, 12.0F, -8.0F, 0.0F, 13.0F, 16.0F), PartPose.rotation(0.0F, 0.0F, zRot));
        gymbag.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, 12.0F, -8.0F, 0.0F, 13.0F, 16.0F), PartPose.rotation(0.0F, 0.0F, -zRot));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
