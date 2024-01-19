package jimenezli.neuro21.entity.ai.goal;

import jimenezli.neuro21.entity.NeurosamaEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Animal;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Implementation copied from FollowParentGoal.
 */
public class MiyuneFollowNeurosamaGoal extends Goal {
    private final Animal animal;
    @Nullable
    private NeurosamaEntity neurosama;
    private final double speedModifier;
    private int timeToRecalcPath;

    public MiyuneFollowNeurosamaGoal(Animal animal, double d) {
        this.animal = animal;
        this.speedModifier = d;
    }

    public boolean canUse() {
        List<? extends NeurosamaEntity> list = this.animal.level.getEntitiesOfClass(NeurosamaEntity.class, this.animal.getBoundingBox().inflate(8.0, 4.0, 8.0));
        NeurosamaEntity followedNeurosama = null;
        double d = Double.MAX_VALUE;

        for (NeurosamaEntity neurosama : list) {
            if (neurosama.getAge() >= 0) {
                double e = this.animal.distanceToSqr(neurosama);
                if (!(e > d)) {
                    d = e;
                    followedNeurosama = neurosama;
                }
            }
        }

        if (followedNeurosama == null) {
            return false;
        } else if (d < 9.0) {
            return false;
        } else {
            this.neurosama = followedNeurosama;
            return true;
        }
    }

    public boolean canContinueToUse() {
        if (this.animal.getAge() >= 0) {
            return false;
        } else if (!this.neurosama.isAlive()) {
            return false;
        } else {
            double d = this.animal.distanceToSqr(this.neurosama);
            return !(d < 9.0) && !(d > 256.0);
        }
    }

    public void start() {
        this.timeToRecalcPath = 0;
    }

    public void stop() {
        this.neurosama = null;
    }

    public void tick() {
        if (--this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = this.adjustedTickDelay(10);
            this.animal.getNavigation().moveTo(this.neurosama, this.speedModifier);
        }
    }
}
