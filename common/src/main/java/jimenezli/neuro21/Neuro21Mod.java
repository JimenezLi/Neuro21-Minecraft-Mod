package jimenezli.neuro21;

import dev.architectury.registry.registries.DeferredRegister;
import jimenezli.neuro21.handler.BlockHandler;
import jimenezli.neuro21.handler.EntityHandler;
import jimenezli.neuro21.handler.ItemHandler;
import jimenezli.neuro21.handler.SoundHandler;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Neuro21Mod {
    public static final String MOD_ID = "neuro21";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, Registry.BLOCK_REGISTRY);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(MOD_ID, Registry.ENTITY_TYPE_REGISTRY);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(MOD_ID, Registry.SOUND_EVENT_REGISTRY);

    public static void preInit() {
        SoundHandler.register();
        EntityHandler.register();
        BlockHandler.register();
        ItemHandler.register();

        SOUND_EVENTS.register();
        ENTITY_TYPES.register();
        BLOCKS.register();
        ITEMS.register();
    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(Neuro21Mod.MOD_ID, name);
    }
}
