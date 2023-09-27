package me.tryfle.invsnow.utils.particles

import net.weavemc.loader.api.event.SubscribeEvent
import me.tryfle.invsnow.config.StoredConfig
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiChat
import net.weavemc.loader.api.event.RenderGameOverlayEvent
import org.lwjgl.input.Mouse

object ParticleManager {
    var hasChanged = false
    val mc: Minecraft
        get() = Minecraft.getMinecraft()
    private val particleGenerator = ParticleGenerator()

    @SubscribeEvent
    @Suppress("Unused_Parameter")
    fun render(event: RenderGameOverlayEvent) {
        if (mc.currentScreen != null && mc.currentScreen !is GuiChat && StoredConfig.ModEnabled) {
            particleGenerator.draw(Mouse.getX(), Mouse.getY())
        }
    }
}
