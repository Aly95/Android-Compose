package com.alyhuggan.mycompose.utils

import android.app.Activity
import android.content.Context
import android.content.Intent

fun Activity.toast(message: String) = toast(this, message)

fun <T> Activity.getIntent(mClass: Class<T>): Intent = Intent(this, mClass)
fun <T> Activity.startActivity(mClass: Class<T>) = startActivity(getIntent(mClass))

