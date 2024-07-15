package net.gbm.western_wasteland.datagen;

import net.gbm.western_wasteland.Western_Wasteland;
import net.gbm.western_wasteland.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Western_Wasteland.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ROSE_GOLD_BLOCK);
//        blockWithItem(ModBlocks.ROSE_GOLD_ORE);
        blockWithItem(ModBlocks.WESTERN_SAND);
//        blockWithItem(ModBlocks.WESTERN_SANDSTONE);
//        blockWithItem(ModBlocks.WESTERN_CUT_SANDSTONE);
        blockWithItem(ModBlocks.TEMPERED_GLASS);

        logBlock((RotatedPillarBlock) ModBlocks.DEADWOOD_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.DEADWOOD.get(), blockTexture(ModBlocks.DEADWOOD_LOG.get()), blockTexture(ModBlocks.DEADWOOD_LOG.get()));

        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_DEADWOOD_LOG.get(), blockTexture(ModBlocks.STRIPPED_DEADWOOD_LOG.get()),
                new ResourceLocation(Western_Wasteland.MOD_ID, "block/stripped_deadwood_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_DEADWOOD.get(), blockTexture(ModBlocks.STRIPPED_DEADWOOD.get()),
                blockTexture(ModBlocks.STRIPPED_DEADWOOD_LOG.get()));

        blockItem(ModBlocks.DEADWOOD_LOG);
        blockItem(ModBlocks.DEADWOOD);
        blockItem(ModBlocks.STRIPPED_DEADWOOD_LOG);
        blockItem(ModBlocks.STRIPPED_DEADWOOD);

        blockWithItem(ModBlocks.DEADWOOD_PLANKS);
        leavesBlock(ModBlocks.DEADWOOD_LEAVES);

        stairsBlock(((StairBlock) ModBlocks.DEADWOOD_STAIRS.get()), blockTexture(ModBlocks.DEADWOOD_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.DEADWOOD_SLAB.get()), blockTexture(ModBlocks.DEADWOOD_PLANKS.get()), blockTexture(ModBlocks.DEADWOOD_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.DEADWOOD_BUTTON.get()), blockTexture(ModBlocks.DEADWOOD_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.DEADWOOD_PRESSURE_PLATE.get()), blockTexture(ModBlocks.DEADWOOD_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.DEADWOOD_FENCE.get()), blockTexture(ModBlocks.DEADWOOD_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.DEADWOOD_FENCE_GATE.get()), blockTexture(ModBlocks.DEADWOOD_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.DEADWOOD_DOOR.get()), modLoc("block/deadwood_door_bottom"), modLoc("block/deadwood_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.DEADWOOD_TRAPDOOR.get()), modLoc("block/deadwood_trapdoor"), true, "cutout");

    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(Western_Wasteland.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }


    // cria o bloco e o item do bloco direto
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
