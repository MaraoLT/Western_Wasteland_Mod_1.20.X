package net.gbm.western_wasteland.item;

import net.gbm.western_wasteland.Western_Wasteland;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Western_Wasteland.MOD_ID);

    public static final RegistryObject<Item> DEAD_HORN = ITEMS.register("dead_horn",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HORN_BLADE = ITEMS.register("horn_blade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ROSE_GOLD = ITEMS.register("raw_rose_gold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_INGOT = ITEMS.register("rose_gold_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BULLET = ITEMS.register("bullet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_FLOWER = ITEMS.register("cactus_flower",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
