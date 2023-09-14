package jimenezli.neuro21.forge;

import jimenezli.neuro21.handler.SoundHandler;
import jimenezli.neuro21.util.Neuro21SoundType;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSoundEventsImpl {
    public static final SoundEvent NEUROSAMA_AMBIENT = new SoundEvent(SoundHandler.NEUROSAMA_AMBIENT);
    public static final SoundEvent NEUROSAMA_HEART = new SoundEvent(SoundHandler.NEUROSAMA_HEART);
    public static final SoundEvent EVIL_NEUROSAMA_AMBIENT = new SoundEvent(SoundHandler.EVIL_NEUROSAMA_AMBIENT);

    @SubscribeEvent
    public static void registerSoundEvents(RegisterEvent event) {
        register(event);
    }

    public static void register(Object optionalEvent) {
        assert optionalEvent != null;
        RegisterEvent event = (RegisterEvent) optionalEvent;
        event.register(ForgeRegistries.Keys.SOUND_EVENTS, registry -> {
            registry.register(SoundHandler.NEUROSAMA_AMBIENT, NEUROSAMA_AMBIENT);
            registry.register(SoundHandler.NEUROSAMA_HEART, NEUROSAMA_HEART);
            registry.register(SoundHandler.EVIL_NEUROSAMA_AMBIENT, EVIL_NEUROSAMA_AMBIENT);
        });
    }

    public static SoundEvent getNeurosamaSound(Neuro21SoundType type) {
        return (type == Neuro21SoundType.HEART) ? NEUROSAMA_HEART : NEUROSAMA_AMBIENT;
    }

    public static SoundEvent getEvilNeurosamaSound(Neuro21SoundType type) {
        return EVIL_NEUROSAMA_AMBIENT;
    }
}
