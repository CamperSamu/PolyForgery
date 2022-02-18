package com.campersamu.polyforgery.compat.polydex;


import eu.pb4.polydex.api.ItemEntry;
import eu.pb4.polydex.api.ItemPageView;
import eu.pb4.polydex.api.PolydexUtils;
import eu.pb4.sgui.api.elements.GuiElement;
import eu.pb4.sgui.api.gui.layered.Layer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.collection.DefaultedList;
import wraith.alloyforgery.recipe.AlloyForgeRecipe;

@SuppressWarnings("deprecation")
public class AlloyForgeryRecipeView implements ItemPageView<AlloyForgeRecipe> {

    @Override
    public GuiElement getIcon(ItemEntry itemEntry, AlloyForgeRecipe alloyForgeRecipe, ServerPlayerEntity serverPlayerEntity, Runnable runnable) {
        return new GuiElement(Items.BRICKS.getDefaultStack(), GuiElement.EMPTY_CALLBACK);
    }

    @Override
    public void renderLayer(ItemEntry itemEntry, AlloyForgeRecipe recipe, ServerPlayerEntity serverPlayerEntity, Layer layer, Runnable runnable) {
        DefaultedList<Ingredient> ingredients = recipe.getIngredients();

        for(int i = 0; i < 10; ++i) {
            ItemStack[] stacks = new ItemStack[0];
            if (ingredients.size() > i) {
                stacks = PolydexUtils.readIngredient(ingredients.get(i));
            }

            layer.setSlot(i % 5 + 9 * (i / 5) + 10, PolydexUtils.getIngredientDisplay(stacks));
        }

        layer.setSlot(25, new GuiElement(recipe.getOutput(), GuiElement.EMPTY_CALLBACK));
    }

    public static void init(){
        ItemPageView.registerRecipe(AlloyForgeRecipe.Type.INSTANCE, new AlloyForgeryRecipeView());
    }
}
