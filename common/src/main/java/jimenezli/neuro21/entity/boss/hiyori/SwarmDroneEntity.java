package jimenezli.neuro21.entity.boss.hiyori;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.Level;

public class SwarmDroneEntity extends Bee {
    public SwarmDroneEntity(EntityType<? extends Bee> entityType, Level level) {
        super(entityType, level);
    }
}
