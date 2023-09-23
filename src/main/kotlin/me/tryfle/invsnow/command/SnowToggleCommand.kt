package me.tryfle.invsnow.command

import net.minecraft.client.Minecraft
import net.weavemc.loader.api.command.Command
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting
import me.tryfle.invsnow.config.StoredConfig

class SnowToggleCommand: Command("togglesnow") {
    override fun handle(args: Array<out String>) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(ChatComponentText(EnumChatFormatting.AQUA.toString() + "Inventory snow has been" + (if (StoredConfig.ModEnabled) " disabled" else " enabled") + "."))
        StoredConfig.ModEnabled = !StoredConfig.ModEnabled
    }
}