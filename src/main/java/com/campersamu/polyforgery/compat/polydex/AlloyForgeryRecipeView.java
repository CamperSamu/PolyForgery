package com.campersamu.polyforgery.compat.polydex;


import eu.pb4.sgui.api.elements.GuiElement;
import eu.pb4.sgui.api.elements.GuiElementBuilder;
import eu.pb4.sgui.api.gui.layered.Layer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;
import wraith.alloyforgery.recipe.AlloyForgeRecipe;

import java.util.List;

public class AlloyForgeryRecipeView /*implements AbstractRecipePolydexPage<AlloyForgeRecipe>*/ {

    /*@Override
    public GuiElement getIcon(ItemEntry itemEntry, AlloyForgeRecipe recipe, ServerPlayerEntity serverPlayerEntity, Runnable runnable) {
        return new GuiElementBuilder(Items.BRICKS)
                .setName(Text.translatable("container.alloy_forgery.rei.title"))
                .setLore(List.of(
                        Text.translatable("container.alloy_forgery.rei.min_tier", recipe.getMinForgeTier()).setStyle(Style.EMPTY.withColor(Formatting.GRAY)),
                        Text.translatable("container.alloy_forgery.rei.fuel_per_tick", recipe.getFuelPerTick()).setStyle(Style.EMPTY.withColor(Formatting.GRAY))
                ))
                .build();
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

        //noinspection deprecation
        layer.setSlot(25, new GuiElement(recipe.getOutput(), GuiElement.EMPTY_CALLBACK));
    }

    public static void init(){
        ItemPageView.registerRecipe(AlloyForgeRecipe.Type.INSTANCE, new AlloyForgeryRecipeView());
    }

    @Override
    public ItemStack typeIcon(ServerPlayerEntity player) {
        return new GuiElementBuilder(Items.BRICKS)
                .setName(Text.translatable("container.alloy_forgery.rei.title"))
                .setLore(List.of(
                        Text.translatable("container.alloy_forgery.rei.min_tier", recipe.getMinForgeTier()).setStyle(Style.EMPTY.withColor(Formatting.GRAY)),
                        Text.translatable("container.alloy_forgery.rei.fuel_per_tick", recipe.getFuelPerTick()).setStyle(Style.EMPTY.withColor(Formatting.GRAY))
                ))
                .build();
    }

    @Override
    public void createPage(@Nullable PolydexEntry entry, ServerPlayerEntity player, PageBuilder layer) {

    }*/
}
