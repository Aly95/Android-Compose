package com.alyhuggan.mycompose.utils

fun Int.isDivisibleBy(num: Int) = this % num == 0
fun Long.isDivisibleBy(num: Long) = this % num == 0.toLong()
fun Double.isDivisibleBy(num: Double) = this % num == 0.0