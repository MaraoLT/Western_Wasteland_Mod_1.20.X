package net.gbm.western_wasteland.datagen;

import net.gbm.western_wasteland.Western_Wasteland;
import net.gbm.western_wasteland.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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


    }

    // cria o bloco e o item do bloco direto
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
