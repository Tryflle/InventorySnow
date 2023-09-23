package me.tryfle.invsnow.command

import net.minecraft.client.Minecraft
import net.weavemc.loader.api.command.Command
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting
import me.tryfle.invsnow.config.StoredConfig
import me.tryfle.invsnow.gui.ConfigGui

//Ignore this for now, it's not working. I'll fix it later. It's meant to toggle the GUI.
class SnowGuiCommand: Command("snowconfig") {
    override fun handle(args: Array<out String>) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(ChatComponentText(EnumChatFormatting.AQUA.toString() + "Inventory snow has been" + (if (StoredConfig.ModEnabled) " disabled" else " enabled") + "."))
        Minecraft.getMinecraft().displayGuiScreen(ConfigGui())
    }
}