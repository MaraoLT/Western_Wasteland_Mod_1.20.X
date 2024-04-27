package net.gbm.western_wasteland.entity.custom;

import net.gbm.western_wasteland.entity.ModEntities;
import net.minecraft.client.resources.metadata.animation.AnimationFrame;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.keyframe.AnimationPoint;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class DeadBullEntity extends Animal implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public DeadBullEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.3f).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.8D, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Skeleton.class, true));
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return ModEntities.DEAD_BULL.get().create(serverLevel);
    }

    @Override
//    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
//        //controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
//        //controllerRegistrar.add(new AnimationController<>(this, "attackController", 0, this::attackPredicate));
//        //controllerRegistrar.add(DefaultAnimations.genericAttackAnimation(this, RawAnimation.begin().thenPlay("animation.dead_bull.attack")));
//        controllerRegistrar.add(DefaultAnimations.genericWalkIdleController(this));
//        controllerRegistrar.add(DefaultAnimations.genericAttackAnimation(this, RawAnimation.begin().thenPlay("animation.dead_bull.attack")));
//    }
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController[]{DefaultAnimations.genericWalkIdleController(this)});
        controllers.add(new AnimationController[]{DefaultAnimations.genericAttackAnimation(this, DefaultAnimations.ATTACK_STRIKE)});
    }

//    private PlayState attackPredicate(AnimationState<DeadBullEntity> deadBullEntityAnimationState) {
//        if (this.swinging) {
//            deadBullEntityAnimationState.getController().setAnimation(RawAnimation.begin()
//                    .then("animation.dead_bull.attack", Animation.LoopType.DEFAULT));
//            return PlayState.CONTINUE;
//        } else {
//            deadBullEntityAnimationState.getController().forceAnimationReset();
//            return PlayState.STOP;
//        }
//    }

//    private PlayState predicate(AnimationState<DeadBullEntity> deadBullEntityAnimationState) {
//        if(deadBullEntityAnimationState.isMoving()) {
//            deadBullEntityAnimationState.getController().setAnimation(RawAnimation.begin().
//                    then("animation.dead_bull.walk", Animation.LoopType.LOOP));
//            return PlayState.CONTINUE;
//        }
//
//        deadBullEntityAnimationState.getController().setAnimation(RawAnimation.begin()
//                .then("animation.dead_bull.idle", Animation.LoopType.LOOP));
//        return PlayState.CONTINUE;
//    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
