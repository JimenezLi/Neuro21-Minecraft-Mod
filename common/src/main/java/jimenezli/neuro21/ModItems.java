package jimenezli.neuro21;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;

public class ModItems {
    @ExpectPlatform
    public static void register(Object optionalEvent) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Item getHeartItem() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Item getIronmilkItem() {
        throw new AssertionError();
    }
}
