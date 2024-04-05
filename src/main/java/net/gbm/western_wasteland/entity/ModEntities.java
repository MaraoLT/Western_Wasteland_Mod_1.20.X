package net.gbm.western_wasteland.entity;

import net.gbm.western_wasteland.Western_Wasteland;
import net.gbm.western_wasteland.entity.custom.DeadBullEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Western_Wasteland.MOD_ID);

    public static final RegistryObject<EntityType<DeadBullEntity>> DEAD_BULL =
            ENTITY_TYPES.register("dead_bull",
                    () -> EntityType.Builder.of(DeadBullEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(Western_Wasteland.MOD_ID, "dead_bull").toString()));
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
