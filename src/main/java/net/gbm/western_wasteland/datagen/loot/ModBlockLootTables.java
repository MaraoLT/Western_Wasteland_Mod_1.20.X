package net.gbm.western_wasteland.datagen.loot;

import net.gbm.western_wasteland.block.ModBlocks;
import net.gbm.western_wasteland.datagen.ModItemModelProvider;
import net.gbm.western_wasteland.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ROSE_GOLD_BLOCK.get());
        this.dropSelf(ModBlocks.WESTERN_SAND.get());
        this.dropSelf(ModBlocks.WESTERN_SANDSTONE.get());
        this.dropSelf(ModBlocks.WESTERN_CUT_SANDSTONE.get());
        this.dropSelf(ModBlocks.WESTERN_CACTUS.get());
        this.dropSelf(ModBlocks.TEMPERED_GLASS.get());

        this.add(ModBlocks.ROSE_GOLD_ORE.get(),
                block -> createOreDrop(ModBlocks.ROSE_GOLD_ORE.get(), ModItems.RAW_ROSE_GOLD.get()));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
