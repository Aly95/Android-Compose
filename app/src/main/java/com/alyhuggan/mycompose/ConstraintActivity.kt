package com.alyhuggan.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class ConstraintActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraints = ConstraintSet {
                val greenBox = createRefFor("greenBox")
                val redBox = createRefFor("redBox")
                val yellowBox = createRefFor("yellowBox")
                val guideline = createGuidelineFromTop(0.2f)

                constrain(greenBox) {
                    top.linkTo(guideline)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }
                constrain(yellowBox) {
                    top.linkTo(greenBox.bottom)
                    start.linkTo(greenBox.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }
                constrain(redBox) {
                    top.linkTo(yellowBox.bottom)
                    start.linkTo(greenBox.start)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.value(100.dp)
                    height = Dimension.fillToConstraints
                }
                createHorizontalChain(greenBox, yellowBox, redBox, chainStyle = ChainStyle.Spread)
            }
            ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier
                        .background(Color.Green)
                        .layoutId("greenBox"))
                Box(modifier = Modifier
                    .background(Color.Yellow)
                    .layoutId("yellowBox"))
                Box(modifier = Modifier
                    .background(Color.Red)
                    .layoutId("redBox"))
            }
        }
    }
}