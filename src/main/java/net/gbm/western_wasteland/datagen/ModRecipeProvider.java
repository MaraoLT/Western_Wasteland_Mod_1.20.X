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

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_GOLD_BLOCK.get())
//                .pattern("RRR")
//                .pattern("RRR")
//                .pattern("RRR")
//                .define('R', ModItems.ROSE_GOLD_INGOT.get())
//                .unlockedBy(getHasName(ModItems.ROSE_GOLD_INGOT.get()), has(ModItems.ROSE_GOLD_INGOT.get()))
//                .save(consumer);
        ShapedRecipeNine(consumer, RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT.get(), ModBlocks.ROSE_GOLD_BLOCK.get());

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT.get(), 9)
//                .requires(ModBlocks.ROSE_GOLD_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.ROSE_GOLD_BLOCK.get()), has(ModBlocks.ROSE_GOLD_BLOCK.get()))
//                .save(consumer);
        ShapelessRecipeOne(consumer, RecipeCategory.MISC, ModBlocks.ROSE_GOLD_BLOCK.get(), ModItems.ROSE_GOLD_INGOT.get(), 9);

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WESTERN_SANDSTONE.get())
//                .pattern("SS")
//                .pattern("SS")
//                .define('S', ModBlocks.WESTERN_SAND.get())
//                .unlockedBy(getHasName(ModBlocks.WESTERN_SANDSTONE.get()), has(ModBlocks.WESTERN_SANDSTONE.get()))
//                .save(consumer);
        ShapedRecipeFour(consumer, RecipeCategory.MISC, ModBlocks.WESTERN_SAND.get(), ModBlocks.WESTERN_SANDSTONE.get());

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WESTERN_CUT_SANDSTONE.get(), 4)
//                .pattern("SS")
//                .pattern("SS")
//                .define('S', ModBlocks.WESTERN_SANDSTONE.get())
//                .unlockedBy(getHasName(ModBlocks.WESTERN_CUT_SANDSTONE.get()), has(ModBlocks.WESTERN_CUT_SANDSTONE.get()))
//                .save(consumer);
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

        ShapedRecipeFour(consumer, RecipeCategory.MISC, ModBlocks.DEADWOOD_LOG.get(), ModBlocks.DEADWOOD.get(), 3);
        ShapedRecipeFour(consumer, RecipeCategory.MISC, ModBlocks.STRIPPED_DEADWOOD_LOG.get(), ModBlocks.STRIPPED_DEADWOOD.get(), 3);

//        ShapelessRecipeOne(consumer, RecipeCategory.MISC, ModBlocks.DEADWOOD.get(), ModBlocks.DEADWOOD_PLANKS.get(), 4);
        ShapelessRecipeOne(consumer, RecipeCategory.MISC, ModBlocks.DEADWOOD_LOG.get(), ModBlocks.DEADWOOD_PLANKS.get(), 4);
//        ShapelessRecipeOne(consumer, RecipeCategory.MISC, ModBlocks.STRIPPED_DEADWOOD.get(), ModBlocks.DEADWOOD_PLANKS.get(), 4);
//        ShapelessRecipeOne(consumer, RecipeCategory.MISC, ModBlocks.STRIPPED_DEADWOOD_LOG.get(), ModBlocks.DEADWOOD_PLANKS.get(), 4);
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
