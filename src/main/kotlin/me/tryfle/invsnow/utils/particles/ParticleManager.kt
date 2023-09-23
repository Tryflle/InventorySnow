package me.tryfle.invsnow.utils.particles

import net.minecraft.client.gui.inventory.GuiContainer
import net.weavemc.loader.api.event.SubscribeEvent
import net.weavemc.loader.api.event.GuiOpenEvent
import me.tryfle.invsnow.config.StoredConfig
import org.lwjgl.input.Mouse

object ParticleManager {
    var hasChanged = false
    private val particleGenerator = ParticleGenerator()

    @SubscribeEvent
    fun render(event: GuiOpenEvent) {
        if (event.screen is GuiContainer && StoredConfig.ModEnabled) {
            particleGenerator.draw(Mouse.getX(), Mouse.getY())
        }
    }
}