package jimenezli.neuro21;

import dev.architectury.injectables.annotations.ExpectPlatform;
import jimenezli.neuro21.util.Neuro21DiscType;
import jimenezli.neuro21.util.Neuro21SoundType;
import net.minecraft.sounds.SoundEvent;

public class ModSoundEvents {
    @ExpectPlatform
    public static void register(Object optionalEvent) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static SoundEvent getNeurosamaSound(Neuro21SoundType type) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static SoundEvent getEvilNeurosamaSound(Neuro21SoundType type) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static SoundEvent getDiscSound(Neuro21DiscType type) {
        throw new AssertionError();
    }
}
