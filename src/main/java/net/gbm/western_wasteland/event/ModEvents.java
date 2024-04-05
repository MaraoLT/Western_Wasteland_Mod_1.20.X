package net.gbm.western_wasteland.event;

import net.gbm.western_wasteland.Western_Wasteland;
import net.gbm.western_wasteland.entity.custom.DeadBullEntity;
import net.gbm.western_wasteland.entity.ModEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Western_Wasteland.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.DEAD_BULL.get(), DeadBullEntity.setAttributes());
    }
}
