package com.campersamu.polyforgery.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import wraith.alloyforgery.block.ForgeControllerBlock;
import wraith.alloyforgery.block.ForgeControllerBlockEntity;

@Mixin(ForgeControllerBlockEntity.class)
public abstract class ForgeControllerBlockEntityMixin extends BlockEntity {
    @Shadow @Final private Direction facing;

    public ForgeControllerBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;updateComparators(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/Block;)V"))
    private void polySmokeParticles(CallbackInfo ci) {
        assert this.world != null;
        BlockState currentState = this.world.getBlockState(this.pos);
        if (currentState.get(ForgeControllerBlock.LIT) && this.world instanceof ServerWorld serverWorld) {
            Vec3d center = Vec3d.ofCenter(this.pos).add(Vec3d.of(this.facing.getOpposite().getVector()));
            serverWorld.spawnParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, center.getX(), center.getY(), center.getZ(), 2, 0.0, 0.1, 0.0, 0.1);
            serverWorld.spawnParticles(ParticleTypes.LARGE_SMOKE, center.getX(), center.getY(), center.getZ(), 5, 0.0, 0.1, 0.0, 0.1);

            if (world.random.nextDouble() > 0.65) {
                serverWorld.spawnParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, center.getX(), center.getY(), center.getZ(), 1, 0.0, 0.01, 0.0, 0.02);
            }
        }
    }

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lio/wispforest/owo/particles/systems/ParticleSystem;spawn(Lnet/minecraft/world/World;Lnet/minecraft/util/math/Vec3d;Ljava/lang/Object;)V"))
    private void polyFlameParticles(CallbackInfo ci) {
        if (this.world instanceof ServerWorld serverWorld) {
            var flamePos = Vec3d.ofCenter(this.pos).add(this.facing.getOffsetX() * 0.5, -0.2, this.facing.getOffsetZ() * 0.5);
            serverWorld.spawnParticles(ParticleTypes.SMALL_FLAME, flamePos.getX(), flamePos.getY(), flamePos.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.03D);
        }
    }
}
