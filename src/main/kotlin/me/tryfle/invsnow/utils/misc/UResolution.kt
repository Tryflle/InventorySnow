package me.tryfle.invsnow.utils.misc

//as per the license of where i skidded this from (https://github.com/EssentialGG/UniversalCraft/blob/master/src/main/kotlin/gg/essential/universal/UResolution.kt) i am stating that i changed nothing except the package
//#if MC<=11202
import net.minecraft.client.gui.ScaledResolution
//#endif

object UResolution {
    //#if MC<=11202
    private var scaledResolution: ScaledResolution? = null
    private data class ScaledResolutionInputs(val width: Int, val height: Int, val scale: Int, val unicode: Boolean)
    private var cachedScaledResolutionInputs: ScaledResolutionInputs? = null
    //#endif

    @JvmStatic
    val windowWidth: Int
        get() {
            //#if MC>=11502
            //$$ return UMinecraft.getMinecraft().mainWindow.width
            //#else
            return UMinecraft.getMinecraft().displayWidth
            //#endif
        }

    @JvmStatic
    val windowHeight: Int
        get() {
            //#if MC>=11502
            //$$ return UMinecraft.getMinecraft().mainWindow.height
            //#else
            return UMinecraft.getMinecraft().displayHeight
            //#endif
        }

    @JvmStatic
    val viewportWidth: Int
        get() {
            //#if MC>=11502
            //$$ return UMinecraft.getMinecraft().mainWindow.framebufferWidth
            //#else
            return UMinecraft.getMinecraft().displayWidth
            //#endif
        }

    @JvmStatic
    val viewportHeight: Int
        get() {
            //#if MC>=11502
            //$$ return UMinecraft.getMinecraft().mainWindow.framebufferHeight
            //#else
            return UMinecraft.getMinecraft().displayHeight
            //#endif
        }

    //#if MC<=11202
    private fun get(): ScaledResolution {
        val mc = UMinecraft.getMinecraft()
        val inputs = ScaledResolutionInputs(viewportWidth, viewportHeight, mc.gameSettings.guiScale, mc.isUnicode)
        if (cachedScaledResolutionInputs != inputs) {
            cachedScaledResolutionInputs = inputs
            scaledResolution = ScaledResolution(mc)
        }
        return scaledResolution!!
    }
    //#endif

    @JvmStatic
    val scaledWidth: Int
        get() {
            //#if MC>=11502
            //$$ return UMinecraft.getMinecraft().mainWindow.scaledWidth
            //#else
            return get().scaledWidth
            //#endif
        }

    @JvmStatic
    val scaledHeight: Int
        get() {
            //#if MC>=11502
            //$$ return UMinecraft.getMinecraft().mainWindow.scaledHeight
            //#else
            return get().scaledHeight
            //#endif
        }

    @JvmStatic
    val scaleFactor: Double
        get() {
            //#if MC>=11502
            //$$ return UMinecraft.getMinecraft().mainWindow.guiScaleFactor
            //#else
            return get().scaleFactor.toDouble()
            //#endif
        }
}