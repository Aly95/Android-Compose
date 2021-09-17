package com.alyhuggan.mycompose.utils


import androidx.compose.ui.graphics.Color
import java.util.*

fun getRandomColor(): Color {
    val colors = listOf(
        Color.Yellow,
        Color.Red,
        Color.Cyan,
        Color.Magenta,
        Color.Blue,
        Color.Yellow,
        Color.LightGray
    )
    val rnd = Random()
    return colors[rnd.nextInt(colors.size.dec())]
}