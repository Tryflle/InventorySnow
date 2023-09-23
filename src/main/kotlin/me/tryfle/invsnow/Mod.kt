package me.tryfle.invsnow

import me.tryfle.invsnow.command.*
import me.tryfle.invsnow.utils.particles.ParticleManager
import net.weavemc.loader.api.ModInitializer
import net.weavemc.loader.api.command.CommandBus
import net.weavemc.loader.api.event.EventBus
import net.weavemc.loader.api.event.GuiOpenEvent

//this mod was ported from Polyfrost's REDCATION mod.
class Mod: ModInitializer {

    override fun preInit() {
        println("[InvSnow] Inventory Snow Initializing")
        CommandBus.register(SnowToggleCommand())
        CommandBus.register(SnowGuiCommand())
        CommandBus.register(SnowIntensityCommand())
        EventBus.subscribe(ParticleManager)
        // EventBus.subscribe(GuiOpenEvent::class.java, ParticleManager::)
    }
}