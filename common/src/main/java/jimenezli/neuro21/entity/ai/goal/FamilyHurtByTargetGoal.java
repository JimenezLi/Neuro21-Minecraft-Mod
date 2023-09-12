package jimenezli.neuro21.entity.ai.goal;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This extends HurtByTargetGoal to alert entities of a series of classes.
 */
public class FamilyHurtByTargetGoal extends HurtByTargetGoal {
    protected List<Class<? extends Mob>> toAlert = new ArrayList<>();

    /**
     * If you attack any entity in toAlert list, you will be attacked by all in toAlert list.
     */
    public FamilyHurtByTargetGoal(PathfinderMob pathfinderMob, Class<?>... classs) {
        super(pathfinderMob, classs);
        this.setAlertOthers();
    }

    /**
     * Alert all classes of entities in toAlert list.
     */
    protected void alertOthers(){
        double d0 = this.getFollowDistance();
        AABB axisalignedbb = AABB.unitCubeFromLowerCorner(this.mob.position()).inflate(d0, 10.0D, d0);
        List<Mob> list = new ArrayList<>();
        for (Class<? extends Mob> oclass: this.toAlert) {
            list.addAll(this.mob.level.getEntitiesOfClass(oclass, axisalignedbb));
        }
        Iterator<Mob> iterator = list.iterator();

        while(true) {
            Mob mob;
            do {
                if (!iterator.hasNext()) {
                    return;
                }
                mob = iterator.next();
            } while (this.mob == mob || mob.getTarget() != null || (this.mob instanceof TamableAnimal && ((TamableAnimal) this.mob).getOwner() != ((TamableAnimal) mob).getOwner()) || mob.isAlliedTo(this.mob.getLastHurtByMob()));

            this.alertOther(mob, this.mob.getLastHurtByMob());
        }
    }
}
