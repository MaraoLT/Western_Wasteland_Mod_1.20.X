package net.gbm.western_wasteland.block;

import net.gbm.western_wasteland.Western_Wasteland;
import net.gbm.western_wasteland.block.custom.ModFlammableRotatedPillarBlock;
import net.gbm.western_wasteland.block.custom.TrapBlock;
import net.gbm.western_wasteland.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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


    public static final RegistryObject<Block> DEADWOOD_LOG = registerBlock("deadwood_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(5f)));
    public static final RegistryObject<Block> DEADWOOD = registerBlock("deadwood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(5f)));
    public static final RegistryObject<Block> STRIPPED_DEADWOOD_LOG = registerBlock("stripped_deadwood_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(5f)));
    public static final RegistryObject<Block> STRIPPED_DEADWOOD = registerBlock("stripped_deadwood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(5f)));

    public static final RegistryObject<Block> DEADWOOD_PLANKS = registerBlock("deadwood_planks",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> DEADWOOD_LEAVES = registerBlock("deadwood_leaves",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });


    public static final RegistryObject<Block> DEADWOOD_STAIRS = registerBlock("deadwood_stairs",
            () -> new StairBlock(() -> ModBlocks.DEADWOOD_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy((Blocks.OAK_PLANKS))));
    public static final RegistryObject<Block> DEADWOOD_SLAB = registerBlock("deadwood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> DEADWOOD_BUTTON = registerBlock("deadwood_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> DEADWOOD_PRESSURE_PLATE = registerBlock("deadwood_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_WOOD),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> DEADWOOD_FENCE = registerBlock("deadwood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> DEADWOOD_FENCE_GATE = registerBlock("deadwood_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> DEADWOOD_DOOR = registerBlock("deadwood_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> DEADWOOD_TRAPDOOR = registerBlock("deadwood_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).noOcclusion(), BlockSetType.OAK));


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
