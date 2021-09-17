package com.alyhuggan.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import com.alyhuggan.mycompose.utils.isDivisibleBy
import com.alyhuggan.mycompose.utils.launchedEffectSnackbar
import com.alyhuggan.mycompose.utils.rememberedStateOf
import kotlinx.coroutines.delay

class HandlersActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            Scaffold(scaffoldState = scaffoldState) {
                var counter by rememberedStateOf(0)
                var counter2 = produceState(initialValue = 0) {
                    delay(3000L)
                    value = 5
                }

                if(counter2.value.isDivisibleBy(5) && counter2.value > 0) {
                    scaffoldState.launchedEffectSnackbar("Num = $counter2")
                }

                if(counter.isDivisibleBy(5) && counter > 0) {
                    // LaunchedEffect Cancels coroutine when the if statement is no longer true
//                    LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
//                        scaffoldState.snackbarHostState.showSnackbar("Num = $counter")
//                    }
                    scaffoldState.launchedEffectSnackbar("Num = $counter")
                }

                Button(onClick = { counter++ }) {
                    Text("Click me: $counter")
                }
            }
        }
    }
}



var i = 0

@Composable
fun MyComposable(backPressedDispatcher: OnBackPressedDispatcher) {

    val callback = remember {
        object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                TODO("Not yet implemented")
            }
        }
    }

    SideEffect { // Executed on compose refresh
        i++
    }

    DisposableEffect(key1 = backPressedDispatcher) {
        backPressedDispatcher.addCallback(callback)
        onDispose {
            callback.remove() // How to avoid memory leaks
        }
    }


    Button(onClick = {
        i++
    }) {
        Text("Click Me")
    }
}