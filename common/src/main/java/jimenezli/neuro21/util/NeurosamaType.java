package jimenezli.neuro21.util;

import jimenezli.neuro21.entity.NeurosamaEntity;
import jimenezli.neuro21.handler.EntityHandler;
import net.minecraft.world.entity.EntityType;

public enum NeurosamaType {
    NEUROSAMA,
    EVIL_NEUROSAMA,
    HIYORI;
    // ARG_SAMA

    public static EntityType<? extends NeurosamaEntity> getNeurosama(NeurosamaType type) {
        return switch (type) {
            case HIYORI -> EntityHandler.HIYORI.get();
            case EVIL_NEUROSAMA -> EntityHandler.EVIL_NEUROSAMA.get();
            default -> EntityHandler.NEUROSAMA.get();
        };
    }
}
