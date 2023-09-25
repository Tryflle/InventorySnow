package me.tryfle.invsnow.config

import java.awt.Color

object StoredConfig {
    var ModEnabled: Boolean = false
    var sliderValue: Double = 100.0
    var particles = sliderValue.toInt()
    var snowColor = Color(255, 255, 255)
}