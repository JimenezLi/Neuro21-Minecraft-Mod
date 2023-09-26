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
 * SwarmDroneModel - JimenezLi
 * Created using Tabula 10.5.1 by iChun
 */
public class SwarmDroneModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart core;
    private final ModelPart zPole;
    private final ModelPart[] xPole;
    private final ModelPart[] yPole;
    private final ModelPart[] propellers;

    public SwarmDroneModel(ModelPart modelPart) {
        this.root = modelPart;
        this.xPole = new ModelPart[2];
        this.yPole = new ModelPart[4];
        this.propellers = new ModelPart[4];

        this.core = modelPart.getChild("swarm_drone");
        this.zPole = core.getChild("z_pole");
        this.xPole[0] = zPole.getChild("x_pole_left");
        this.xPole[1] = zPole.getChild("x_pole_right");
        for (int i = 0; i < 2; i++) {
            this.yPole[i * 2]     = xPole[i].getChild("y_pole_front");
            this.yPole[i * 2 + 1] = xPole[i].getChild("y_pole_back");
        }
        for (int i = 0; i < 4; i++) {
            this.propellers[i] = this.yPole[i].getChild("propeller");
        }
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(T entity, float f, float g, float h, float i, float j) {
        this.propellers[0].yRot = this.propellers[3].yRot = h;
        this.propellers[1].yRot = this.propellers[2].yRot = -h;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition core = partDefinition.addOrReplaceChild("swarm_drone", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0f, 16.0f, 0.0f));
        PartDefinition z_pole = core.addOrReplaceChild("z_pole", CubeListBuilder.create().texOffs(24, 0).addBox(-8.0F, -0.5F, -0.5F, 16.0F, 1.0F, 1.0F), PartPose.ZERO);
        PartDefinition x_pole_left  = z_pole.addOrReplaceChild("x_pole_left",  CubeListBuilder.create().texOffs(16, 2).addBox(-0.5F, -0.5F, -8.0F, 1.0F, 1.0F, 16.0F), PartPose.offset(-8.5f, 0.0f, 0.0f));
        PartDefinition x_pole_right = z_pole.addOrReplaceChild("x_pole_right", CubeListBuilder.create().texOffs(16, 2).addBox(-0.5F, -0.5F, -8.0F, 1.0F, 1.0F, 16.0F), PartPose.offset(8.5f, 0.0f, 0.0f));
        PartDefinition y_pole_left_front  = x_pole_left .addOrReplaceChild("y_pole_front", CubeListBuilder.create().texOffs(58, 0).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F), PartPose.offset(0.0f, -4.5f, -7.5f));
        PartDefinition y_pole_left_back   = x_pole_left .addOrReplaceChild("y_pole_back",  CubeListBuilder.create().texOffs(58, 0).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F), PartPose.offset(0.0f, -4.5f, 7.5f));
        PartDefinition y_pole_right_front = x_pole_right.addOrReplaceChild("y_pole_front", CubeListBuilder.create().texOffs(58, 0).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F), PartPose.offset(0.0f, -4.5f, -7.5f));
        PartDefinition y_pole_right_back  = x_pole_right.addOrReplaceChild("y_pole_back",  CubeListBuilder.create().texOffs(58, 0).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F), PartPose.offset(0.0f, -4.5f, 7.5f));
        y_pole_left_front .addOrReplaceChild("propeller", CubeListBuilder.create().texOffs(34, 2).addBox(-4.0F, -0.5F, -0.5F, 8.0F, 1.0F, 1.0F), PartPose.offset(0.0f, -4.5f, 0.0f));
        y_pole_left_back  .addOrReplaceChild("propeller", CubeListBuilder.create().texOffs(34, 2).addBox(-4.0F, -0.5F, -0.5F, 8.0F, 1.0F, 1.0F), PartPose.offset(0.0f, -4.5f, 0.0f));
        y_pole_right_front.addOrReplaceChild("propeller", CubeListBuilder.create().texOffs(34, 2).addBox(-4.0F, -0.5F, -0.5F, 8.0F, 1.0F, 1.0F), PartPose.offset(0.0f, -4.5f, 0.0f));
        y_pole_right_back .addOrReplaceChild("propeller", CubeListBuilder.create().texOffs(34, 2).addBox(-4.0F, -0.5F, -0.5F, 8.0F, 1.0F, 1.0F), PartPose.offset(0.0f, -4.5f, 0.0f));
        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}
