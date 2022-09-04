package com.campersamu.polyforgery.poly;

import eu.pb4.sgui.api.gui.SimpleGui;
import io.github.theepicblock.polymc.impl.poly.gui.GuiUtils;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import wraith.alloyforgery.AlloyForgeScreenHandler;

import java.util.List;

import static com.campersamu.polyforgery.Init.id;

public class ForgeGui extends SimpleGui {
    private final AlloyForgeScreenHandler base;
    private int fuelProgress = 0;
    private int smeltProgress = 0;
    private int lavaProgress = 0;

    private static final String[] FUEL_ICON = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final String[] SMELT_ICON = new String[]{"0", "1", "2", "3", "4"};
    private static final String[] LAVA_ICON = new String[]{"0", "1", "2", "3"};

    public ForgeGui(ServerPlayerEntity player, AlloyForgeScreenHandler base) {
        super(ScreenHandlerType.GENERIC_9X3, player, false);
        this.base = base;

        List<Slot> baseSlots = GuiUtils.removePlayerSlots(base.slots);

        setSlotRedirect(18, baseSlots.get(0)); // Fuel
        setSlotRedirect(17, baseSlots.get(1)); // Output

        setSlotRedirect(2, baseSlots.get(2)); // Input
        setSlotRedirect(3, baseSlots.get(3));
        setSlotRedirect(4, baseSlots.get(4));
        setSlotRedirect(5, baseSlots.get(5));
        setSlotRedirect(6, baseSlots.get(6));
        setSlotRedirect(11, baseSlots.get(7));
        setSlotRedirect(12, baseSlots.get(8));
        setSlotRedirect(13, baseSlots.get(9));
        setSlotRedirect(14, baseSlots.get(10));
        setSlotRedirect(15, baseSlots.get(11));

        update();
    }

    private void update() {
        fuelProgress = (int) Math.ceil(base.getFuelProgress() / 4.8);
        smeltProgress = (int) Math.ceil(base.getSmeltProgress() / 3.8);
        lavaProgress = (int) Math.ceil(base.getLavaProgress() / 12.5);

        this.setTitle(Text.empty()
                .append(Text.literal("-0.").setStyle(Style.EMPTY.withFont(id("gui")).withColor(Formatting.WHITE)))
                .append(fuelProgress == 0 ? Text.empty() : Text.literal("." + FUEL_ICON[fuelProgress - 1] + "-").setStyle(Style.EMPTY.withFont(id("fuel")).withColor(Formatting.WHITE)))
                .append(smeltProgress == 0 ? Text.empty() : Text.literal("." + SMELT_ICON[smeltProgress - 1] + "-").setStyle(Style.EMPTY.withFont(id("smelt")).withColor(Formatting.WHITE)))
                .append(lavaProgress == 0 ? Text.empty() : Text.literal("." + LAVA_ICON[lavaProgress - 1] + "-").setStyle(Style.EMPTY.withFont(id("lava")).withColor(Formatting.WHITE)))
                .append(Text.translatable("container.alloy_forgery.forge_controller"))
        );
    }

    @Override
    public void onTick() {
        super.onTick();
        if (Math.ceil(base.getFuelProgress() / 4.8) != fuelProgress ||
                (int) Math.ceil(base.getSmeltProgress() / 3.8) != smeltProgress ||
                (int) Math.ceil(base.getLavaProgress() / 12.5) != lavaProgress
        ) {
            update();
        }
    }
}
