package net.gbm.western_wasteland.potion;

import net.gbm.western_wasteland.Western_Wasteland;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotion {
    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, Western_Wasteland.MOD_ID);

    public static final RegistryObject<Potion> TEQUILA = POTIONS.register("tequila",
            () -> new Potion(new MobEffectInstance(MobEffects.CONFUSION, 200, 0)));

    public static void register(IEventBus eventBus) {

    }
}
