package com.campersamu.polyforgery.poly;

import io.github.theepicblock.polymc.api.gui.GuiPoly;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import wraith.alloyforgery.AlloyForgeScreenHandler;

public class ForgeGuiPoly implements GuiPoly {

    @Override
    public ScreenHandler replaceScreenHandler(ScreenHandler base, ServerPlayerEntity player, int syncId) {
        var gui = new ForgeGui(player, (AlloyForgeScreenHandler) base);
        gui.open();
        return null;
    }
}
