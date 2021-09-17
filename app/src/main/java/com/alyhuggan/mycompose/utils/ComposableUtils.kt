package com.alyhuggan.mycompose.utils

import android.content.Context
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.ui.material.Scaffold
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun context(): Context {
    return LocalContext.current
}

@Composable
fun toast(message: String) = toast(context(), message)

@Composable
fun <T> rememberedStateOf(value: T): MutableState<T> = remember { mutableStateOf(value) }

fun ScaffoldState.showSnackbar(scope: CoroutineScope, message: String) {
    scope.launch {
        snackbarHostState.showSnackbar(message)
    }
}

@Composable
fun ScaffoldState.launchedEffectSnackbar(message: String) {
    LaunchedEffect(key1 = snackbarHostState) {
        snackbarHostState.showSnackbar(message)
    }
}
