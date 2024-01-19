package jimenezli.neuro21.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class GigaVedalEntity extends VedalEntity {
    public GigaVedalEntity(EntityType<? extends VedalEntity> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.MOVEMENT_SPEED, 0.3).add(Attributes.MAX_HEALTH, 20.0);
    }

    public void tick() {
        super.tick();
        this.setSpeed(0.3f);
    }
}
