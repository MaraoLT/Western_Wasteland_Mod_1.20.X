package net.gbm.western_wasteland.block;

import net.gbm.western_wasteland.Western_Wasteland;
import net.gbm.western_wasteland.item.ModItems;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockCollisions;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Properties;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Western_Wasteland.MOD_ID);

    public static final RegistryObject<Block> ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.ANVIL)));

    public static final RegistryObject<Block> ROSE_GOLD_ORE = registerBlock("rose_gold_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.5f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    // Tempered Glass is explosion resistent
    public static final RegistryObject<Block> TEMPERED_GLASS = registerBlock("tempered_glass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).explosionResistance(1200.0F)));

    // gravidade adicionada de forma amatongas
    public static final RegistryObject<Block> WESTERN_SAND = registerBlock("western_sand",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> WESTERN_SANDSTONE = registerBlock("western_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> WESTERN_CUT_SANDSTONE = registerBlock("western_cut_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE)));

    public static final RegistryObject<Block> WESTERN_CACTUS = registerBlock("western_cactus",
            () -> new CactusBlock(BlockBehaviour.Properties.copy(Blocks.CACTUS)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // associa um item a um bloco
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
