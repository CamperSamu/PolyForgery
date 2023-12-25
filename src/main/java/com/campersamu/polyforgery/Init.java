package com.campersamu.polyforgery;

import com.campersamu.polyforgery.compat.polydex.AlloyForgeryRecipeView;
import com.campersamu.polyforgery.poly.ForgeGuiPoly;
import io.github.theepicblock.polymc.api.PolyMcEntrypoint;
import io.github.theepicblock.polymc.api.PolyRegistry;
import io.github.theepicblock.polymc.api.resource.ModdedResources;
import io.github.theepicblock.polymc.api.resource.PolyMcResourcePack;
import io.github.theepicblock.polymc.api.resource.SoundAsset;
import io.github.theepicblock.polymc.impl.misc.logging.SimpleLogger;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wraith.alloyforgery.AlloyForgery;

import static net.fabricmc.loader.api.FabricLoader.getInstance;

public class Init implements PolyMcEntrypoint, ModInitializer {
    public static final String MOD_ID = "polyforgery";
    public static final Logger LOGGER = LoggerFactory.getLogger("poly-forgery");

    @Override
    public void registerModSpecificResources(ModdedResources moddedResources, PolyMcResourcePack pack, SimpleLogger logger) {
        pack.setAsset(MOD_ID, "font/gui.json", new SoundAsset(() -> moddedResources.getInputStream(MOD_ID, "font/gui.json")));
        pack.setAsset(MOD_ID, "font/fuel.json", new SoundAsset(() -> moddedResources.getInputStream(MOD_ID, "font/fuel.json")));
        pack.setAsset(MOD_ID, "font/smelt.json", new SoundAsset(() -> moddedResources.getInputStream(MOD_ID, "font/smelt.json")));
        pack.setAsset(MOD_ID, "font/lava.json", new SoundAsset(() -> moddedResources.getInputStream(MOD_ID, "font/lava.json")));
        pack.setAsset(MOD_ID, "textures/gui/forge_controller.png",  new SoundAsset(() -> moddedResources.getInputStream(MOD_ID, "textures/gui/forge_controller.png")));
        pack.setAsset(MOD_ID, "textures/gui/fuel.png",  new SoundAsset(() -> moddedResources.getInputStream(MOD_ID, "textures/gui/fuel.png")));
        pack.setAsset(MOD_ID, "textures/gui/smelt.png",  new SoundAsset(() -> moddedResources.getInputStream(MOD_ID, "textures/gui/smelt.png")));
        pack.setAsset(MOD_ID, "textures/gui/lava.png",  new SoundAsset(() -> moddedResources.getInputStream(MOD_ID, "textures/gui/lava.png")));
    }

    @Override
    public void registerPolys(PolyRegistry registry) {
        registry.registerGuiPoly(AlloyForgery.ALLOY_FORGE_SCREEN_HANDLER_TYPE, new ForgeGuiPoly());

        LOGGER.info("WHAT IS A FORGE AND WHY IS IT FULL OF POLYMER??!?");
    }

    @Override
    public void onInitialize() {
        /*if (getInstance().isModLoaded("polydex")){
            LOGGER.info("Polydex found! PolyForgery is going to add the recipe screen to the reicpe viewer!");
            AlloyForgeryRecipeView.init();
        }*/
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
