package jimenezli.neuro21.handler;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import static jimenezli.neuro21.Neuro21Mod.prefix;

public class SoundHandler {
    public static final ResourceLocation NEUROSAMA_AMBIENT = prefix("neurosama_ambient");
    public static final ResourceLocation NEUROSAMA_HEART = prefix("neurosama_heart");
    public static final ResourceLocation EVIL_NEUROSAMA_AMBIENT = prefix("evil_neurosama_ambient");

    public static final String DISC_LIVING_MILLENNIUM = "living_millennium";

    public static ResourceLocation Disc(String discName) {
        return prefix("music_disc." + discName);
    }
}
