package com.github.seventeen.stopboom.client;

import com.github.seventeen.stopboom.command.StopBoomCommandManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;

public class StopboomClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        StopBoomCommandManager.register();

        // This callback runs in the client before the block-use packet is sent.
        // Returning FAIL cancels the local interaction, so the server never receives
        // the bed-use packet and cannot trigger the bed explosion.
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (StopBoomCommandManager.isEnabled
                    && world.dimension() == Level.END
                    && world.getBlockState(hitResult.getBlockPos()).getBlock() instanceof BedBlock) {
                player.displayClientMessage(Component.literal("BOOM BLOCKED!!"), true);
                return InteractionResult.FAIL;
            }
            return InteractionResult.PASS;
        });
    }
}
