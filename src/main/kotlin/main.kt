package com.lvanh

import com.lvanh.p802.Solution
import com.lvanh.utils.run
import kotlin.reflect.full.declaredFunctions

fun main(): Unit = Solution::class.declaredFunctions.first().run()