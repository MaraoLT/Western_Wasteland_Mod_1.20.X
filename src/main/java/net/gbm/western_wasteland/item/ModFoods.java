package net.gbm.western_wasteland.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.HoneyBottleItem;
import net.minecraftforge.event.entity.living.MobEffectEvent;

public class ModFoods {
    public static final FoodProperties CACTUS_FLOWER = new FoodProperties.Builder().nutrition(6)
            .saturationMod(0.6f).effect(
                    () -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20 * 120), 0.2f).build();

}
