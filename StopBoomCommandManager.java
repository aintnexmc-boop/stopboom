package com.github.seventeen.stopboom.command;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.minecraft.network.chat.Component;

public final class StopBoomCommandManager {
    public static boolean isEnabled = true;

    private StopBoomCommandManager() {}

    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) ->
            dispatcher.register(ClientCommandManager.literal("stopboom")
                .then(ClientCommandManager.literal("enable").executes(context -> {
                    isEnabled = true;
                    context.getSource().sendFeedback(Component.literal("Successfully enabled StopBoom!"));
                    return 1;
                }))
                .then(ClientCommandManager.literal("disable").executes(context -> {
                    isEnabled = false;
                    context.getSource().sendFeedback(Component.literal("Successfully disabled StopBoom!"));
                    return 1;
                }))));
    }
}
