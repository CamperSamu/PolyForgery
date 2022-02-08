package com.campersamu.polyforgery.mixin;

import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import wraith.alloyforgery.block.ForgeControllerBlockEntity;

@Mixin(ForgeControllerBlockEntity.class)
public abstract class SetForgeScreenNameMixin {
    private static final Text GUI_TEXT = new LiteralText("\uF808\uEff1").formatted(Formatting.WHITE);

    @Inject(method = "getDisplayName", at = @At("TAIL"), cancellable = true)
    private void setForgeScreenName(CallbackInfoReturnable<Text> cir) {
        cir.setReturnValue(GUI_TEXT);
    }
}
