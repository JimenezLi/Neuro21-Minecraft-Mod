package jimenezli.neuro21.client.model.geom;

import net.minecraft.client.model.geom.ModelLayerLocation;

import static jimenezli.neuro21.Neuro21Mod.prefix;

public class Neuro21ModelLayers {
    public static final ModelLayerLocation GYMBAG = register("gymbag");
    public static final ModelLayerLocation SWARM_DRONE = register("swarm_drone");

    private static ModelLayerLocation register(String name) {
        return register(name, "main");
    }

    private static ModelLayerLocation register(String name, String part) {
        return new ModelLayerLocation(prefix(name), part);
    }
}
