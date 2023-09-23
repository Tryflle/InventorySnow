package me.tryfle.invsnow.command

import net.minecraft.client.Minecraft
import net.weavemc.loader.api.command.Command
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting
import me.tryfle.invsnow.config.StoredConfig

class SnowIntensityCommand : Command("snowintensity") {
    override fun handle(args: Array<out String>) {
        if (args.isNotEmpty()) {
            try {
                val newIntensity = args[0].toInt()
                if (newIntensity in 1..100) {
                    StoredConfig.sliderValue = newIntensity.toDouble()
                    Minecraft.getMinecraft().thePlayer.addChatMessage(
                        ChatComponentText(
                            EnumChatFormatting.AQUA.toString() +
                                    "Snow intensity has been set to $newIntensity."
                        )
                    )
                } else {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(
                        ChatComponentText(
                            EnumChatFormatting.RED.toString() +
                                    "Intensity must be between 1 and 100."
                        )
                    )
                }
            } catch (e: NumberFormatException) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(
                    ChatComponentText(
                        EnumChatFormatting.RED.toString() +
                                "Invalid input. Please enter a valid number."
                    )
                )
            }
        } else {
            Minecraft.getMinecraft().thePlayer.addChatMessage(
                ChatComponentText(
                    EnumChatFormatting.RED.toString() +
                            "Usage: /snowintensity <value>"
                )
            )
        }
    }
}
