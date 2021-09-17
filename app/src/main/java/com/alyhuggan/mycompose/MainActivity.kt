package com.alyhuggan.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alyhuggan.mycompose.ui.theme.MyComposeTheme
import com.alyhuggan.mycompose.utils.getRandomColor
import com.alyhuggan.mycompose.utils.startActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    ActivityLinks(getActivityList())
                }
            }
        }
    }

    private fun getActivityList(): List<Activity<*>> {
        return listOf<Activity<*>>(
            Activity(
                ImageCardActivity::class.java,
                "Image Card"
            ),
            Activity(
                TextStylingActivity::class.java,
                "Text Styling"
            ),
            Activity(
                StateActivity::class.java,
                "State"
            ),
            Activity(
                TextFieldsButtonsSnackbarsActivity::class.java,
                "Text Field, Button, Snackbars"
            ),
            Activity(
                ListActivity::class.java,
                "List"
            ),
            Activity(
                ConstraintActivity::class.java,
                "Constraint"
            ),
            Activity(
                HandlersActivity::class.java,
                "Handler"
            ),
            Activity(
                AnimationActivity::class.java,
                "Animation"
            ),
        )
    }
}

@Composable
fun ActivityLinks(activities: List<Activity<*>>) {
    val context = LocalContext.current

    Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            activities.forEach { activity ->
                Column(
                    Modifier
                        .fillMaxWidth()
                        .background(getRandomColor())
                        .padding(8.dp)
                        .clickable {
                            context.startActivity(activity.activity)
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Click me for the ${activity.activityText} Activity")
                }
            }
        }
    }
}


@Composable
fun Greeting(message: Message) {
    val context = LocalContext.current
    Row(Modifier.fillMaxSize(1f)) {
        Column(
            modifier = Modifier // Modifiers done sequencially, padding after border or else padding is applied to border
                .clickable {
                    context.startActivity(ImageCardActivity::class.java)
                }
                .fillMaxSize(0.7f)
                .background(Color.Green)
                .border(6.dp, Color.Yellow)
                .padding(horizontal = 8.dp, vertical = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Click me to start the Image Card Activity", modifier = Modifier
                    .offset(5.dp, 10.dp)
                    .border(6.dp, Color.Cyan)
            )
            Spacer(
                modifier = Modifier
                    .height(82.dp)
            )
            Text(text = "Goodbye ${message.second}!")
            Text(text = "Total ${message.second}!")
        }
        Column(
            modifier = Modifier
                .fillMaxSize(0.6f)
                .clickable {
                    context.startActivity(TextStylingActivity::class.java)
                }
                .background(Color.Blue)
                .height(200.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Click me for the Text Styling Activity")
            Text(text = "Goodbye ${message.second}!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeTheme {
        Greeting(Message("First", "Second"))
    }
}

data class Message(
    val first: String = "First",
    val second: String = "Second"
)

data class Activity<T>(
    val activity: Class<T>,
    val activityText: String
)

data class Activitys(
    val activity: ComponentActivity,
    val activityText: String
)