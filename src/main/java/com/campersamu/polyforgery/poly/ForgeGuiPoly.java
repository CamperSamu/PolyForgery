package com.campersamu.polyforgery.poly;

import io.github.theepicblock.polymc.api.gui.GuiManager;
import io.github.theepicblock.polymc.api.gui.GuiPoly;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class ForgeGuiPoly implements GuiPoly {
    @Override
    public GuiManager createGuiManager(ScreenHandler base, ServerPlayerEntity player) {
        return new ForgeManagerPoly(base, player);
    }

    public static class ForgeManagerPoly extends GuiManager {

        public ForgeManagerPoly(ScreenHandler base, ServerPlayerEntity player) {
            super(base, player);
        }

        @Override
        public ScreenHandler getInitialHandler(int initialSyncId) {
            return new ForgeHandlerPoly(initialSyncId, player.getInventory(), base);
        }
    }
}
