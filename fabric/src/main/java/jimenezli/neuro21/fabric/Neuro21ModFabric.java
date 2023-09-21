package jimenezli.neuro21.fabric;

import jimenezli.neuro21.Neuro21Mod;
import net.fabricmc.api.ModInitializer;

public class Neuro21ModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Neuro21Mod.preInit();
    }
}
