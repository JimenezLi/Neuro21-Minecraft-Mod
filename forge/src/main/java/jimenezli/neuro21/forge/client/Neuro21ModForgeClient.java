package jimenezli.neuro21.forge.client;

import jimenezli.neuro21.ModEntityTypes;
import jimenezli.neuro21.Neuro21Mod;
import jimenezli.neuro21.client.entity.AnnyRenderer;
import jimenezli.neuro21.client.entity.IronCowRenderer;
import jimenezli.neuro21.client.entity.NeurosamaRenderer;
import jimenezli.neuro21.client.entity.VedalRenderer;
import jimenezli.neuro21.entity.NeurosamaType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD, modid = Neuro21Mod.MOD_ID)
public class Neuro21ModForgeClient {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        setupEntityRenderers();
    }

    public static void setupEntityRenderers() {
        EntityRenderers.register(ModEntityTypes.getVedalEntity(), VedalRenderer::new);
        EntityRenderers.register(ModEntityTypes.getAnnyEntity(), AnnyRenderer::new);
        EntityRenderers.register(ModEntityTypes.getNeurosamaEntity(NeurosamaType.NEUROSAMA), NeurosamaRenderer::new);
        EntityRenderers.register(ModEntityTypes.getNeurosamaEntity(NeurosamaType.EVIL_NEUROSAMA), NeurosamaRenderer::new);
        EntityRenderers.register(ModEntityTypes.getNeurosamaEntity(NeurosamaType.HIYORI), NeurosamaRenderer::new);
        EntityRenderers.register(ModEntityTypes.getIronCowEntity(), IronCowRenderer::new);
    }
}
