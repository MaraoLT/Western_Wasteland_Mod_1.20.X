//package net.gbm.western_wasteland.entity.client;
//
//import net.gbm.western_wasteland.Western_Wasteland;
//import net.gbm.western_wasteland.entity.custom.DeadBullEntity;
//import net.minecraft.client.tutorial.Tutorial;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.util.Mth;
//import software.bernie.geckolib.constant.DataTickets;
//import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
//import software.bernie.geckolib.core.animation.AnimationState;
//import software.bernie.geckolib.core.object.DataTicket;
//import software.bernie.geckolib.model.GeoModel;
//import software.bernie.geckolib.model.data.EntityModelData;
//
//public class DeadBullModel extends GeoModel<DeadBullEntity> {
//    @Override
//    public ResourceLocation getModelResource(DeadBullEntity deadBullEntity) {
//        return new ResourceLocation(Western_Wasteland.MOD_ID, "geo/dead_bull.geo.json");
//    }
//
//    @Override
//    public ResourceLocation getTextureResource(DeadBullEntity deadBullEntity) {
//        return new ResourceLocation(Western_Wasteland.MOD_ID, "textures/entity/dead_bull.png");
//    }
//
//    @Override
//    public ResourceLocation getAnimationResource(DeadBullEntity deadBullEntity) {
//        return new ResourceLocation(Western_Wasteland.MOD_ID, "animations/dead_bull.animation.json");
//    }
//
//    @Override
//    public void setCustomAnimations(DeadBullEntity animatable, long instanceId, AnimationState<DeadBullEntity> animationState) {
//        CoreGeoBone head = getAnimationProcessor().getBone("head");
//
//        if (head != null) {
//            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
//
//            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
//            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
//        }
//    }
//}

package net.gbm.western_wasteland.entity.client;

import net.gbm.western_wasteland.Western_Wasteland;
import net.gbm.western_wasteland.entity.custom.DeadBullEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class DeadBullModel extends DefaultedEntityGeoModel<DeadBullEntity> {
    public DeadBullModel() {
        super(new ResourceLocation(Western_Wasteland.MOD_ID, "dead_bull"));
    }

    // We want our model to render using the translucent render type
    @Override
    public RenderType getRenderType(DeadBullEntity animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(getTextureResource(animatable));
    }
}
