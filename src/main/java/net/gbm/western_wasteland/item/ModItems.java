package net.gbm.western_wasteland.item;

import net.gbm.western_wasteland.Western_Wasteland;
import net.gbm.western_wasteland.entity.ModEntities;
import net.gbm.western_wasteland.item.custom.HarmonicaItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
            () -> new Item(new Item.Properties().food(ModFoods.CACTUS_FLOWER)));
    public static final RegistryObject<Item> HARMONICA = ITEMS.register("harmonica",
            () -> new HarmonicaItem(new Item.Properties()));

    public static final RegistryObject<Item> ROSE_GOLD_HELMET = ITEMS.register("rose_gold_helmet",
            () -> new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_CHESTPLATE = ITEMS.register("rose_gold_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_LEGGINGS = ITEMS.register("rose_gold_leggings",
            () -> new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_BOOTS = ITEMS.register("rose_gold_boots",
            () -> new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> DEAD_BULL_SPAWN_EGG = ITEMS.register("dead_bull_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.DEAD_BULL, 0x3C3333, 0x100D0D, new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
