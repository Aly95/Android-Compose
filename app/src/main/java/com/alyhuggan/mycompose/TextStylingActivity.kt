package com.alyhuggan.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

class TextStylingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fonts = FontFamily(
            Font(R.font.roboto_bold, FontWeight.Bold),
            Font(R.font.roboto_medium, FontWeight.Medium),
            Font(R.font.roboto_regular, FontWeight.Normal)
        )
        setContent {
            Box(
                Modifier
                    .fillMaxSize(1f)
                    .background(Color.Green)
            ) {
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red,
                                fontSize = 60.sp
                            )
                        ) {
                            append("H")
                        }
                        append("ello")
                    },
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}