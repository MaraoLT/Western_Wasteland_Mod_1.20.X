package net.gbm.western_wasteland.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.gbm.western_wasteland.Western_Wasteland;
import net.gbm.western_wasteland.entity.custom.DeadBullEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DeadBullRenderer extends GeoEntityRenderer<DeadBullEntity> {
    public DeadBullRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DeadBullModel());
    }

    @Override
    public ResourceLocation getTextureLocation(DeadBullEntity animatable) {
        return new ResourceLocation(Western_Wasteland.MOD_ID, "textures/entity/dead_bull.png");
    }

    @Override
    public void render(DeadBullEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
