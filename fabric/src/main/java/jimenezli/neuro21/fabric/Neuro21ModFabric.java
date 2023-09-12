package jimenezli.neuro21.fabric;

import jimenezli.neuro21.ModEntityTypes;
import jimenezli.neuro21.ModItems;
import net.fabricmc.api.ModInitializer;

public class Neuro21ModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ModEntityTypes.register(null);
        ModEntityTypes.registerAttributes();
        ModItems.register(null);
    }
}
