package jimenezli.neuro21.entity.boss.hiyori;

import jimenezli.neuro21.handler.EntityHandler;
import jimenezli.neuro21.handler.SoundHandler;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class HiyoriBossEntity extends Monster {
    private final ServerBossEvent bossEvent;
    private int nextUltimateMoveTicks;

    public HiyoriBossEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.bossEvent = new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.PROGRESS);
        this.nextUltimateMoveTicks = 400;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 500).add(Attributes.MOVEMENT_SPEED, 0.4).add(Attributes.FOLLOW_RANGE, 40).add(Attributes.ATTACK_DAMAGE, 4.0);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public void startSeenByPlayer(ServerPlayer serverPlayer) {
        super.startSeenByPlayer(serverPlayer);
        this.bossEvent.addPlayer(serverPlayer);
    }

    public void stopSeenByPlayer(ServerPlayer serverPlayer) {
        super.stopSeenByPlayer(serverPlayer);
        this.bossEvent.removePlayer(serverPlayer);
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    public void checkDespawn() {
        if (this.level.getDifficulty() == Difficulty.PEACEFUL && this.shouldDespawnInPeaceful()) {
            this.discard();
        } else {
            this.noActionTime = 0;
        }
    }

    public void aiStep() {
        super.aiStep();
        if (this.nextUltimateMoveTicks-- < 0) {
            this.nextUltimateMoveTicks = 200;
            this.performUltimateMove();
        }
    }

    private void performUltimateMove() {
        RandomSource randomSource = this.level.getRandom();
        switch (randomSource.nextInt(3)) {
            case 0 -> performSwarm();
            case 1 -> performGymbag();
            default -> performLightning();
        }
    }

    private void performSwarm() {
        for (int i = 0; i < 4; i++) {
            double dx = (i / 2 == 0) ? 3.0D : -3.0D;
            double dz = (i % 2 == 0) ? 3.0D : -3.0D;
            SwarmDroneEntity swarmDrone = new SwarmDroneEntity(EntityHandler.SWARM_DRONE.get(), this.level);
            swarmDrone.setPos(this.getX() + dx, this.getEyeY() + 3.0, this.getZ() + dz);
            this.level.addFreshEntity(swarmDrone);
        }
        this.playSound(SoundHandler.HIYORI_BOSS_SWARM.getOrNull(), 2.0f, 1.0f);
    }

    private void performGymbag() {
        for (int i = 0; i < 4; i++) {
            double dx = (i / 2 == 0) ? 3.0D : -3.0D;
            double dz = (i % 2 == 0) ? 3.0D : -3.0D;
            GymbagEntity gymbag = new GymbagEntity(EntityHandler.GYMBAG.get(), this.level);
            gymbag.setPos(this.getX() + dx, this.getEyeY(), this.getZ() + dz);
            this.level.addFreshEntity(gymbag);
        }
        this.playSound(SoundHandler.HIYORI_BOSS_GYMBAG.getOrNull(), 2.0f, 1.0f);
    }

    private void performLightning() {
        RandomSource randomSource = this.level.getRandom();
        for (int i = 0; i < 32; i++) {
            float nextAngle = randomSource.nextFloat() * Mth.PI * 2.0f;
            double distance = randomSource.nextDouble() * 5.0 + 5.0;
            LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
            lightningBolt.setPos(this.getX() + Mth.cos(nextAngle) * distance, this.getY(), this.getZ() + Mth.sin(nextAngle) * distance);
            this.level.addFreshEntity(lightningBolt);
        }
    }
}
