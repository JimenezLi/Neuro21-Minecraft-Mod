package jimenezli.neuro21.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public class EvilNeurosamaEntity extends NeurosamaEntity{
    public EvilNeurosamaEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.neurosamaType = NeurosamaType.EVIL_NEUROSAMA;
    }

    @Override
    protected void registerCustomGoals() {
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.MOVEMENT_SPEED, 0.4).add(Attributes.MAX_HEALTH, 20.0);
    }
}