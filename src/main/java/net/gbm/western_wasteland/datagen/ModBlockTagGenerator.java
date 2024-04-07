package net.gbm.western_wasteland.datagen;

import net.gbm.western_wasteland.Western_Wasteland;
import net.gbm.western_wasteland.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Western_Wasteland.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ROSE_GOLD_ORE.get(),
                        ModBlocks.ROSE_GOLD_BLOCK.get(),
                        ModBlocks.WESTERN_SANDSTONE.get(),
                        ModBlocks.WESTERN_CUT_SANDSTONE.get()
                        );

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.WESTERN_SAND.get()
                        );

//        this.tag(BlockTags.NEEDS_STONE_TOOL)
//                .add();

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ROSE_GOLD_ORE.get(),
                        ModBlocks.ROSE_GOLD_BLOCK.get()
                );

//         this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
//                .add();

//        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
//                .add();


        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.DEADWOOD.get())
                .add(ModBlocks.DEADWOOD_LOG.get())
                .add(ModBlocks.STRIPPED_DEADWOOD.get())
                .add(ModBlocks.STRIPPED_DEADWOOD_LOG.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.DEADWOOD_PLANKS.get());

        // para conectarem
        this.tag(BlockTags.FENCES)
                .add(ModBlocks.DEADWOOD_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.DEADWOOD_FENCE_GATE.get());

    }
}
