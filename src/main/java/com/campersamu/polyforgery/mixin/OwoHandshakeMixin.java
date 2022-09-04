package com.campersamu.polyforgery.mixin;

import io.wispforest.owo.network.OwoHandshake;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("UnstableApiUsage")
@Mixin(OwoHandshake.class)
public abstract class OwoHandshakeMixin {
    @Shadow private static boolean HANDSHAKE_REQUIRED;

    @Inject(method ="requireHandshake", at = @At("HEAD"), cancellable = true, remap = false)
    private static void forceDisableHandshake(CallbackInfo ci) {
        HANDSHAKE_REQUIRED = false;
        ci.cancel();
    }
}
