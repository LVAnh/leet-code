package com.lvanh

import com.lvanh.p257.Solution
import com.lvanh.utils.run
import kotlin.reflect.full.declaredFunctions

fun main() {
    Solution::class.declaredFunctions.first().run()
}