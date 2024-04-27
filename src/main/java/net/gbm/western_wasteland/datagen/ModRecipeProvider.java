package net.gbm.western_wasteland.datagen;

import net.gbm.western_wasteland.Western_Wasteland;
import net.gbm.western_wasteland.block.ModBlocks;
import net.gbm.western_wasteland.item.ModItems;
import net.minecraft.client.tutorial.CraftPlanksTutorialStep;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.rmi.server.RMIServerSocketFactory;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> ROSE_GOLD_SMELTABLES = List.of(ModItems.RAW_ROSE_GOLD.get(),
            ModBlocks.ROSE_GOLD_ORE.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, ROSE_GOLD_SMELTABLES, RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT.get(), 0.25f, 100, "rose_gold");
        oreBlasting(consumer, ROSE_GOLD_SMELTABLES, RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT.get(), 0.25f, 100, "rose_gold");


        smeltingResultFromBase(consumer, Items.GLASS, ModBlocks.WESTERN_SAND.get());

        ShapedRecipeNine(consumer, RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT.get(), ModBlocks.ROSE_GOLD_BLOCK.get());

        ShapelessRecipeOne(consumer, RecipeCategory.MISC, ModBlocks.ROSE_GOLD_BLOCK.get(), ModItems.ROSE_GOLD_INGOT.get(), 9);

        ShapedRecipeFour(consumer, RecipeCategory.MISC, ModBlocks.WESTERN_SAND.get(), ModBlocks.WESTERN_SANDSTONE.get());
        ShapedRecipeFour(consumer, RecipeCategory.MISC, ModBlocks.WESTERN_SANDSTONE.get(), ModBlocks.WESTERN_CUT_SANDSTONE.get(), 4);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TEMPERED_GLASS.get(), 2)
                .pattern(" G ")
                .pattern("GRG")
                .pattern(" G ")
                .define('G', Items.GLASS)
                .define('R', ModItems.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(ModBlocks.TEMPERED_GLASS.get()), has(ModBlocks.TEMPERED_GLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HORN_BLADE.get())
                .pattern("  H")
                .pattern(" H ")
                .pattern("S  ")
                .define('S', Items.STICK)
                .define('H', ModItems.DEAD_HORN.get())
                .unlockedBy(getHasName(ModItems.HORN_BLADE.get()), has(ModItems.HORN_BLADE.get()))
                .save(consumer);

        //ARMOR RECIPES
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ROSE_GOLD_HELMET.get())
                .pattern("RRR")
                .pattern("R R")
                .pattern("   ")
                .define('R', ModItems.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(ModItems.ROSE_GOLD_HELMET.get()), has(ModItems.ROSE_GOLD_HELMET.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ROSE_GOLD_CHESTPLATE.get())
                .pattern("R R")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(ModItems.ROSE_GOLD_CHESTPLATE.get()), has(ModItems.ROSE_GOLD_CHESTPLATE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ROSE_GOLD_LEGGINGS.get())
                .pattern("RRR")
                .pattern("R R")
                .pattern("R R")
                .define('R', ModItems.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(ModItems.ROSE_GOLD_LEGGINGS.get()), has(ModItems.ROSE_GOLD_LEGGINGS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ROSE_GOLD_BOOTS.get())
                .pattern("R R")
                .pattern("R R")
                .pattern("   ")
                .define('R', ModItems.ROSE_GOLD_INGOT.get())
                .unlockedBy(getHasName(ModItems.ROSE_GOLD_BOOTS.get()), has(ModItems.ROSE_GOLD_BOOTS.get()))
                .save(consumer);

        // DEADWOOD RECIPES
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEADWOOD_STAIRS.get(), 4)
                .pattern("P  ")
                .pattern("PP ")
                .pattern("PPP")
                .define('P', ModBlocks.DEADWOOD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.DEADWOOD_STAIRS.get()), has(ModBlocks.DEADWOOD_STAIRS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEADWOOD_SLAB.get(), 3)
                .pattern("   ")
                .pattern("   ")
                .pattern("PPP")
                .define('P', ModBlocks.DEADWOOD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.DEADWOOD_SLAB.get()), has(ModBlocks.DEADWOOD_SLAB.get()))
                .save(consumer);
        ShapelessRecipeOne(consumer, RecipeCategory.REDSTONE, ModBlocks.DEADWOOD_PLANKS.get(), ModBlocks.DEADWOOD_BUTTON.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEADWOOD_PRESSURE_PLATE.get())
                .pattern("  ")
                .pattern("PP")
                .define('P', ModBlocks.DEADWOOD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.DEADWOOD_PRESSURE_PLATE.get()), has(ModBlocks.DEADWOOD_PRESSURE_PLATE.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEADWOOD_FENCE.get(), 3)
                .pattern("   ")
                .pattern("PSP")
                .pattern("PSP")
                .define('P', ModBlocks.DEADWOOD_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.DEADWOOD_FENCE.get()), has(ModBlocks.DEADWOOD_FENCE.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEADWOOD_FENCE_GATE.get())
                .pattern("   ")
                .pattern("SPS")
                .pattern("SPS")
                .define('P', ModBlocks.DEADWOOD_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.DEADWOOD_FENCE_GATE.get()), has(ModBlocks.DEADWOOD_FENCE_GATE.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEADWOOD_DOOR.get(), 3)
                .pattern("PP ")
                .pattern("PP ")
                .pattern("PP ")
                .define('P', ModBlocks.DEADWOOD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.DEADWOOD_DOOR.get()), has(ModBlocks.DEADWOOD_DOOR.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEADWOOD_TRAPDOOR.get(), 2)
                .pattern("   ")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ModBlocks.DEADWOOD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.DEADWOOD_TRAPDOOR.get()), has(ModBlocks.DEADWOOD_TRAPDOOR.get()))
                .save(consumer);

        ShapedRecipeFour(consumer, RecipeCategory.MISC, ModBlocks.DEADWOOD_LOG.get(), ModBlocks.DEADWOOD.get(), 3);
        ShapedRecipeFour(consumer, RecipeCategory.MISC, ModBlocks.STRIPPED_DEADWOOD_LOG.get(), ModBlocks.STRIPPED_DEADWOOD.get(), 3);

//        ShapelessRecipeOne(consumer, RecipeCategory.MISC, ModBlocks.DEADWOOD.get(), ModBlocks.DEADWOOD_PLANKS.get(), 4);
        ShapelessRecipeOne(consumer, RecipeCategory.MISC, ModBlocks.DEADWOOD_LOG.get(), ModBlocks.DEADWOOD_PLANKS.get(), 4);
//        ShapelessRecipeOne(consumer, RecipeCategory.MISC, ModBlocks.STRIPPED_DEADWOOD.get(), ModBlocks.DEADWOOD_PLANKS.get(), 4);
//        ShapelessRecipeOne(consumer, RecipeCategory.MISC, ModBlocks.STRIPPED_DEADWOOD_LOG.get(), ModBlocks.DEADWOOD_PLANKS.get(), 4);


    }


    protected static void ShapelessRecipeOne(Consumer<FinishedRecipe> consumer, RecipeCategory pCategory, ItemLike pIngredient, ItemLike pResult, int pQuantity) {
        ShapelessRecipeBuilder.shapeless(pCategory, pResult, pQuantity)
                .requires(pIngredient)
                .unlockedBy(getHasName(pResult), has(pResult))
                .save(consumer);
    }
    protected static void ShapelessRecipeOne(Consumer<FinishedRecipe> consumer, RecipeCategory pCategory, ItemLike pIngredient, ItemLike pResult) {
        ShapelessRecipeBuilder.shapeless(pCategory, pResult)
                .requires(pIngredient)
                .unlockedBy(getHasName(pResult), has(pResult))
                .save(consumer);
    }
    protected static void ShapedRecipeFour(Consumer<FinishedRecipe> consumer, RecipeCategory pCategory, ItemLike pIngredient, ItemLike pResult, int pQuantity) {
        ShapedRecipeBuilder.shaped(pCategory, pResult, pQuantity)
                .pattern("FF")
                .pattern("FF")
                .define('F', pIngredient)
                .unlockedBy(getHasName(pResult), has(pResult))
                .save(consumer);
    }

    protected static void ShapedRecipeFour(Consumer<FinishedRecipe> consumer, RecipeCategory pCategory, ItemLike pIngredient, ItemLike pResult) {
        ShapedRecipeBuilder.shaped(pCategory, pResult)
                .pattern("FF")
                .pattern("FF")
                .define('F', pIngredient)
                .unlockedBy(getHasName(pResult), has(pResult))
                .save(consumer);
    }
    protected static void ShapedRecipeNine(Consumer<FinishedRecipe> consumer, RecipeCategory pCategory, ItemLike pIngredient, ItemLike pResult, int pQuantity) {
        ShapedRecipeBuilder.shaped(pCategory, pResult, pQuantity)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', pIngredient)
                .unlockedBy(getHasName(pResult), has(pResult))
                .save(consumer);
    }

    protected static void ShapedRecipeNine(Consumer<FinishedRecipe> consumer, RecipeCategory pCategory, ItemLike pIngredient, ItemLike pResult) {
        ShapedRecipeBuilder.shaped(pCategory, pResult)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', pIngredient)
                .unlockedBy(getHasName(pResult), has(pResult))
                .save(consumer);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike),
                    has(itemlike)).save(pFinishedRecipeConsumer, Western_Wasteland.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
