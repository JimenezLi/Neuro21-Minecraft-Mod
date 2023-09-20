package jimenezli.neuro21.handler;

import dev.architectury.registry.registries.RegistrySupplier;
import jimenezli.neuro21.block.ChineseCabbageBlock;

import static jimenezli.neuro21.Neuro21Mod.BLOCKS;

public class BlockHandler {
    public static RegistrySupplier<ChineseCabbageBlock> CHINESE_CABBAGE_BLOCK = BLOCKS.register("chinese_cabbage_block", ChineseCabbageBlock::new);
    public static void register() {
    }
}
