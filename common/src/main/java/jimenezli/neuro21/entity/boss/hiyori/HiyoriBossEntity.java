package jimenezli.neuro21.entity.boss.hiyori;

import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class HiyoriBossEntity extends Monster {
    private final ServerBossEvent bossEvent;

    public HiyoriBossEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.bossEvent = new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.PROGRESS);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 500).add(Attributes.MOVEMENT_SPEED, 0.6).add(Attributes.FOLLOW_RANGE, 40);
    }

    public void startSeenByPlayer(ServerPlayer serverPlayer) {
        super.startSeenByPlayer(serverPlayer);
        this.bossEvent.addPlayer(serverPlayer);
    }

    public void stopSeenByPlayer(ServerPlayer serverPlayer) {
        super.stopSeenByPlayer(serverPlayer);
        this.bossEvent.removePlayer(serverPlayer);
    }
}
