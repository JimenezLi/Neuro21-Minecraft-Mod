package jimenezli.neuro21.fabric;

import jimenezli.neuro21.handler.SoundHandler;
import jimenezli.neuro21.util.Neuro21SoundType;
import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvent;

public class ModSoundEventsImpl {
    public static final SoundEvent NEUROSAMA_AMBIENT = new SoundEvent(SoundHandler.NEUROSAMA_AMBIENT);
    public static final SoundEvent NEUROSAMA_HEART = new SoundEvent(SoundHandler.NEUROSAMA_HEART);
    public static final SoundEvent EVIL_NEUROSAMA_AMBIENT = new SoundEvent(SoundHandler.EVIL_NEUROSAMA_AMBIENT);

    public static void register(Object optionalEvent) {
        Registry.register(Registry.SOUND_EVENT, SoundHandler.NEUROSAMA_AMBIENT, NEUROSAMA_AMBIENT);
        Registry.register(Registry.SOUND_EVENT, SoundHandler.NEUROSAMA_HEART, NEUROSAMA_HEART);
        Registry.register(Registry.SOUND_EVENT, SoundHandler.EVIL_NEUROSAMA_AMBIENT, EVIL_NEUROSAMA_AMBIENT);
    }

    public static SoundEvent getNeurosamaSound(Neuro21SoundType type) {
        return (type == Neuro21SoundType.HEART) ? NEUROSAMA_HEART : NEUROSAMA_AMBIENT;
    }

    public static SoundEvent getEvilNeurosamaSound(Neuro21SoundType type) {
        return EVIL_NEUROSAMA_AMBIENT;
    }
}
