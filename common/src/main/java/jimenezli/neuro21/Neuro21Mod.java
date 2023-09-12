package jimenezli.neuro21;

import jimenezli.neuro21.handler.ItemHandler;
import net.minecraft.resources.ResourceLocation;

public class Neuro21Mod {
    public static final String MOD_ID = "neuro21";

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(Neuro21Mod.MOD_ID, name);
    }
}
