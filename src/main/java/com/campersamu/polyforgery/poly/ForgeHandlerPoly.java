package com.campersamu.polyforgery.poly;

import io.github.theepicblock.polymc.impl.poly.gui.GuiUtils;
import io.github.theepicblock.polymc.impl.poly.gui.StaticSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

import java.util.List;

public class ForgeHandlerPoly extends ScreenHandler {
    protected final ScreenHandler base;
    /**
     * Total amount of slots in this screen. Without the player inventory
     */
    protected final int totalSlots;
    /**
     * Total amount of slots that aren't present in {@link #base}
     */
    protected final int fakedSlots;


    public ForgeHandlerPoly(int syncId, PlayerInventory playerInventory, ScreenHandler base) {
        super(ScreenHandlerType.GENERIC_9X3, syncId);
        int width = 9;
        int height = 3;
        this.base = base;
        this.totalSlots = width * height;
        int fakedSlotsTemp = 0;

        List<Slot> baseSlots = GuiUtils.removePlayerSlots(base.slots);

        for (int i = 0; i < totalSlots; i++) {
            switch (i){
                case 2 -> addSlot(baseSlots.get(2));
                case 3 -> addSlot(baseSlots.get(3));
                case 4 -> addSlot(baseSlots.get(4));
                case 5 -> addSlot(baseSlots.get(5));
                case 6 -> addSlot(baseSlots.get(6));
                case 9 -> addSlot(baseSlots.get(0));
                case 11 -> addSlot(baseSlots.get(7));
                case 12 -> addSlot(baseSlots.get(8));
                case 13 -> addSlot(baseSlots.get(9));
                case 14 -> addSlot(baseSlots.get(10));
                case 15 -> addSlot(baseSlots.get(11));
                case 17 -> addSlot(baseSlots.get(1));
                default -> addSlot(new StaticSlot(new ItemStack(Items.AIR)));
            }
        }

        //Player inventory
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }

        }

        //Player hotbar
        for (int hotbar = 0; hotbar < 9; ++hotbar) {
            this.addSlot(new Slot(playerInventory, hotbar, 8 + hotbar * 18, 142));
        }

        this.fakedSlots = fakedSlotsTemp;
    }


    @Override
    public boolean canUse(PlayerEntity player) {
        return base.canUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        if (index > totalSlots) {
            index -= fakedSlots;
        }
        return base.transferSlot(player, index);
    }
}
