package jimenezli.neuro21.entity.ai.goal;

import jimenezli.neuro21.entity.AnnyEntity;
import jimenezli.neuro21.entity.NeurosamaEntity;
import jimenezli.neuro21.entity.VedalEntity;
import net.minecraft.world.entity.PathfinderMob;

public class NeurosamaFamilyHurtByTargetGoal extends FamilyHurtByTargetGoal{
    /**
     * If you attack any entity in toAlert list, you will be attacked by all in toAlert list.
     */
    public NeurosamaFamilyHurtByTargetGoal(PathfinderMob pathfinderMob, Class<?>... classs) {
        super(pathfinderMob, classs);
        this.toAlert.add(NeurosamaEntity.class);
        this.toAlert.add(VedalEntity.class);
        this.toAlert.add(AnnyEntity.class);
    }
}
