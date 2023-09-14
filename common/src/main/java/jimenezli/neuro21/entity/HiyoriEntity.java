package jimenezli.neuro21.entity;

import jimenezli.neuro21.util.NeurosamaType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public class HiyoriEntity extends NeurosamaEntity {
    public HiyoriEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.neurosamaType = NeurosamaType.HIYORI;
    }

    public boolean isAbandoned() {
        return this.hasCustomName() && this.getName().getString().equals("hiyori");
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 0.5D).add(Attributes.MOVEMENT_SPEED, 0.4).add(Attributes.MAX_HEALTH, 20.0);
    }
}
