package net.araytar.spaaace.datagen;

import net.araytar.spaaace.items.MBlocks;
import net.araytar.spaaace.items.MItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.world.item.Items.BOOK;

public class MRecipeProvider extends RecipeProvider {
    public MRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MBlocks.SPACE_BLOCK.get(), 1)
            .pattern("BBB")
            .pattern("BXB")
            .pattern("BXB")
            .define('B', ItemTags.PLANKS)
            .define('X', BOOK)
            .unlockedBy("has_book", has(Items.BOOK))
            .save(recipeOutput);

        /*
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MBlocks.SPACE_BLOCK.get(), 1)
                .requires(Items.BOOK)
                .requires(ItemTags.PLANKS)
                .unlockedBy("has_book", has(Items.BOOK))
                .save(recipeOutput, "spaaace:space_block_2");


        List<ItemLike> SPACEBLOCK_SMELTABLES = List.of(MBlocks.SPACE_BLOCK);
        oreSmelting(recipeOutput,
                SPACEBLOCK_SMELTABLES,
                RecipeCategory.MISC,
                MBlocks.SPACE_BLOCK.get(),
                0.25f,
                200,
                "space_block"
        );

        oreBlasting(recipeOutput,
                SPACEBLOCK_SMELTABLES,
                RecipeCategory.MISC,
                MBlocks.SPACE_BLOCK.get(),
                0.25f,
                100,
                "space_block"
        );
        */
    }

    protected static void oreSmelting(RecipeOutput recipeOutput,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup) {
        oreCooking(recipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTime,
                pGroup,
                "_from_smelting"
                );

    }

    protected static void oreBlasting(RecipeOutput recipeOutput,
                                      List<ItemLike> pIngredients,
                                      RecipeCategory pCategory,
                                      ItemLike pResult,
                                      float pExperience,
                                      int pCookingTime,
                                      String pGroup) {
        oreCooking(recipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTime,
                pGroup,
                "_from_smelting"
        );

    }
}
