package jimenezli.neuro21.handler;

import dev.architectury.registry.registries.RegistrySupplier;
import jimenezli.neuro21.util.DiscNames;
import net.minecraft.sounds.SoundEvent;

import static jimenezli.neuro21.Neuro21Mod.SOUND_EVENTS;
import static jimenezli.neuro21.Neuro21Mod.prefix;

public class SoundHandler {
    public static final RegistrySupplier<SoundEvent> NEUROSAMA_AMBIENT = RegistrySupplierBuilder("neurosama_ambient");
    public static final RegistrySupplier<SoundEvent> NEUROSAMA_HEART = RegistrySupplierBuilder("neurosama_heart");
    public static final RegistrySupplier<SoundEvent> EVIL_NEUROSAMA_AMBIENT = RegistrySupplierBuilder("evil_neurosama_ambient");
    public static final RegistrySupplier<SoundEvent> DISC = RegistrySupplierBuilder(Disc(DiscNames.LIVING_MILLENNIUM));
    public static final RegistrySupplier<SoundEvent> EXPLOSION = RegistrySupplierBuilder("explosion");
    public static final RegistrySupplier<SoundEvent> HIYORI_BOSS_SWARM = RegistrySupplierBuilder("hiyori_boss_swarm");
    public static final RegistrySupplier<SoundEvent> HIYORI_BOSS_GYMBAG = RegistrySupplierBuilder("hiyori_boss_gymbag");

    private static String Disc(String discName) {
        return "music_disc." + discName;
    }

    private static RegistrySupplier<SoundEvent> RegistrySupplierBuilder(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(prefix(name)));
    }

    public static void register() {
    }
}
