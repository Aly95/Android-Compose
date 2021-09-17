package com.alyhuggan.mycompose.utils

import android.content.Context
import android.content.Intent

fun Context.toast(message: String) = toast(this, message)

fun <T> Context.getIntent(mClass: Class<T>): Intent = Intent(this, mClass)
fun <T> Context.startActivity(mClass: Class<T>) = startActivity(getIntent(mClass))