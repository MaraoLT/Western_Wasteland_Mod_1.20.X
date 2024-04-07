package net.gbm.western_wasteland.datagen.loot;

import net.gbm.western_wasteland.block.ModBlocks;
import net.gbm.western_wasteland.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
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

        this.dropSelf(ModBlocks.DEADWOOD.get());
        this.dropSelf(ModBlocks.DEADWOOD_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_DEADWOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_DEADWOOD_LOG.get());

        this.dropSelf(ModBlocks.DEADWOOD_PLANKS.get());

        this.add(ModBlocks.DEADWOOD_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.DEADWOOD_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES)); // A FAZER: trocar para sapling


        this.dropSelf(ModBlocks.DEADWOOD_STAIRS.get());
        this.dropSelf(ModBlocks.DEADWOOD_BUTTON.get());
        this.dropSelf(ModBlocks.DEADWOOD_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DEADWOOD_TRAPDOOR.get());
        this.dropSelf(ModBlocks.DEADWOOD_FENCE.get());
        this.dropSelf(ModBlocks.DEADWOOD_FENCE_GATE.get());

        this.add(ModBlocks.DEADWOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DEADWOOD_SLAB.get()));
        this.add(ModBlocks.DEADWOOD_DOOR.get(),
                block -> createDoorTable(ModBlocks.DEADWOOD_DOOR.get()));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
