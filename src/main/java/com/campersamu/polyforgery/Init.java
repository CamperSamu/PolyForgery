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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wraith.alloyforgery.AlloyForgery;

import static net.fabricmc.loader.api.FabricLoader.getInstance;

public class Init implements PolyMcEntrypoint, ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("poly-forgery");

    @Override
    public void registerModSpecificResources(ModdedResources moddedResources, PolyMcResourcePack pack, SimpleLogger logger) {
        pack.setAsset("minecraft", "font/default.json", new SoundAsset(() -> moddedResources.getInputStream("minecraft", "font/default.json")));
        pack.setAsset("minecraft", "font/negative_spaces.ttf",  new SoundAsset(() -> moddedResources.getInputStream("minecraft", "font/negative_spaces.ttf")));
        pack.setAsset("polyforgery", "textures/font/forge_controller_gui.png",  new SoundAsset(() -> moddedResources.getInputStream("polyforgery", "textures/font/forge_controller_gui.png")));
        pack.setAsset("minecraft", "lang/en_us.json",  new SoundAsset(() -> moddedResources.getInputStream("polyforgery", "lang/en_us.json")));
        pack.setAsset("minecraft", "lang/de_de.json",  new SoundAsset(() -> moddedResources.getInputStream("polyforgery", "lang/de_de.json")));
        pack.setAsset("minecraft", "lang/en_pt.json",  new SoundAsset(() -> moddedResources.getInputStream("polyforgery", "lang/en_pt.json")));
        pack.setAsset("minecraft", "lang/enws.json",  new SoundAsset(() -> moddedResources.getInputStream("polyforgery", "lang/enws.json")));
        pack.setAsset("minecraft", "lang/it_it.json",  new SoundAsset(() -> moddedResources.getInputStream("polyforgery", "lang/it_it.json")));
        pack.setAsset("minecraft", "lang/lol_us.json",  new SoundAsset(() -> moddedResources.getInputStream("polyforgery", "lang/lol_us.json")));
        pack.setAsset("minecraft", "lang/nn_no.json",  new SoundAsset(() -> moddedResources.getInputStream("polyforgery", "lang/nn_no.json")));
        pack.setAsset("minecraft", "lang/no_no.json",  new SoundAsset(() -> moddedResources.getInputStream("polyforgery", "lang/no_no.json")));
    }

    @Override
    public void registerPolys(PolyRegistry registry) {
        registry.registerGuiPoly(AlloyForgery.ALLOY_FORGE_SCREEN_HANDLER_TYPE, new ForgeGuiPoly());

        LOGGER.info("WHAT IS A FORGE AND WHY IS IT FULL OF POLYMER??!?");
    }

    @Override
    public void onInitialize() {
        if (getInstance().isModLoaded("polydex")){
            LOGGER.info("Polydex found! PolyForgery is going to add the recipe screen to the reicpe viewer!");
            AlloyForgeryRecipeView.init();
        }
    }
}
