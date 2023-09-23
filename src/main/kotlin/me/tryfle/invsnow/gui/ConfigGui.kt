package me.tryfle.invsnow.gui

import net.minecraft.client.gui.GuiButton
import net.minecraft.client.gui.GuiScreen
import net.minecraft.client.Minecraft
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting
import me.tryfle.invsnow.config.StoredConfig
import net.minecraft.client.gui.GuiSlider

//Doesn't seem to work for some reason? If you have any idea of to why, please do let me know, this is annoying.
class ConfigGui : GuiScreen() {
    private var sliderValue = StoredConfig.sliderValue

    override fun initGui() {
        val buttonWithoutSlider = GuiButton(0, width / 2 - 100, height / 2 - 20, "Toggle Snow")
        buttonList.add(buttonWithoutSlider)

        val sliderButton = GuiSlider(
            null,
            1,
            width / 2 - 100,
            height / 2 + 20,
            "Slider Button",
            0.0F,
            100.0F,
            sliderValue.toFloat(),
            null
        )
        buttonList.add(sliderButton)
    }

    override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
        drawDefaultBackground()
        val fr = mc.fontRendererObj

        val title = "InvSnow Config"
        val titleWidth = fr.getStringWidth(title)
        drawString(fr, title, width / 2 - titleWidth / 2, height / 2 - 50, 0xFFFFFF)

        super.drawScreen(mouseX, mouseY, partialTicks)
    }

    override fun actionPerformed(button: GuiButton) {
        when (button.id) {
            0 -> {
                StoredConfig.ModEnabled = !StoredConfig.ModEnabled
                Minecraft.getMinecraft().thePlayer.addChatMessage(ChatComponentText(EnumChatFormatting.AQUA.toString() + "Inventory snow has been" + (if (StoredConfig.ModEnabled) " disabled" else " enabled") + "."))
            }
            1 -> {
                sliderValue = (button as GuiSlider).sliderPosition.toDouble()
                Minecraft.getMinecraft().thePlayer.addChatMessage(ChatComponentText(EnumChatFormatting.AQUA.toString() + "SLIDERVALUE="+ sliderValue.toString() + "."))
            }
        }
    }
}