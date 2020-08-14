/*
 * Copyright © 2020 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of LambdaControls.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package me.lambdaurora.lambdacontrols.client.compat;

import io.github.joaoh1.okzoomer.client.keybinds.ZoomKeybinds;
import me.lambdaurora.lambdacontrols.client.LambdaControlsClient;
import me.lambdaurora.lambdacontrols.client.controller.ButtonBinding;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;

/**
 * Represents a compatibility handler for OkZoomer.
 *
 * @author LambdAurora
 * @version 1.3.0
 * @since 1.1.0
 */
public class OkZoomerCompat implements CompatHandler
{
    @Override
    public void handle(@NotNull LambdaControlsClient mod)
    {
        new ButtonBinding.Builder("zoom")
                .buttons(GLFW.GLFW_GAMEPAD_BUTTON_DPAD_UP, GLFW.GLFW_GAMEPAD_BUTTON_X)
                .onlyInGame()
                .cooldown(true)
                .category(ButtonBinding.MISC_CATEGORY)
                .linkKeybind(ZoomKeybinds.zoomKey)
                .register();

        if (ZoomKeybinds.areExtraKeybindsEnabled()) {
                new ButtonBinding.Builder("zoom.in")
                        .buttons(GLFW.GLFW_GAMEPAD_BUTTON_DPAD_UP, ButtonBinding.axisAsButton(GLFW.GLFW_GAMEPAD_AXIS_RIGHT_TRIGGER, true))
                        .onlyInGame()
                        .cooldown(true)
                        .category(ButtonBinding.MISC_CATEGORY)
                        .linkKeybind(ZoomKeybinds.increaseZoomKey)
                        .register();
                new ButtonBinding.Builder("zoom.out")
                        .buttons(GLFW.GLFW_GAMEPAD_BUTTON_DPAD_UP, ButtonBinding.axisAsButton(GLFW.GLFW_GAMEPAD_AXIS_LEFT_TRIGGER, true))
                        .onlyInGame()
                        .cooldown(true)
                        .category(ButtonBinding.MISC_CATEGORY)
                        .linkKeybind(ZoomKeybinds.decreaseZoomKey)
                        .register();
                new ButtonBinding.Builder("zoom.reset")
                        .onlyInGame()
                        .cooldown(true)
                        .category(ButtonBinding.MISC_CATEGORY)
                        .linkKeybind(ZoomKeybinds.resetZoomKey)
                        .register();
        }
    }
}
