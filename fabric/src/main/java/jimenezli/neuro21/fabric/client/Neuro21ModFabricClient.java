package jimenezli.neuro21.fabric.client;

import jimenezli.neuro21.client.Neuro21ModClient;
import net.fabricmc.api.ClientModInitializer;

public class Neuro21ModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Neuro21ModClient.preInit();
        Neuro21ModClient.Init();
    }
}
