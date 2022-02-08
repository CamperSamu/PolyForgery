package com.campersamu.polyforgery;

import com.campersamu.polyforgery.poly.ForgeGuiPoly;
import io.github.theepicblock.polymc.api.PolyMcEntrypoint;
import io.github.theepicblock.polymc.api.PolyRegistry;
import io.github.theepicblock.polymc.api.resource.ResourcePackMaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wraith.alloyforgery.AlloyForgery;

public class Init implements PolyMcEntrypoint {
    public static final Logger LOGGER = LoggerFactory.getLogger("poly-forgery");

    @Override
    public void registerModSpecificResources(ResourcePackMaker pack) {
        pack.copyAsset("minecraft", "font/default.json");
        pack.copyAsset("minecraft", "font/negative_spaces.ttf");
        pack.copyAsset("polyforgery", "textures/font/forge_controller_gui.png");
    }

    @Override
    public void registerPolys(PolyRegistry registry) {
        registry.registerGuiPoly(AlloyForgery.ALLOY_FORGE_SCREEN_HANDLER_TYPE, new ForgeGuiPoly());

        LOGGER.info("WHAT IS A FORGE AND WHY IS IT FULL OF POLYMER??!?");
    }
}
