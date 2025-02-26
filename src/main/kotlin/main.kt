package com.lvanh

import com.lvanh.p300.Solution
import com.lvanh.utils.run
import kotlin.reflect.full.declaredFunctions

fun main(): Unit = Solution::class.declaredFunctions.first().run()