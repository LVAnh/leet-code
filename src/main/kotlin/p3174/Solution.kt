@file:Suppress("UNUSED")

package com.lvanh.p3174

import java.util.Stack

/**
 * Problem 3174. Clear Digits
 */
class Solution {
    fun clearDigits(s: String): String {
        var stack = StringBuilder()
        for (i in s.indices) {
            if (s[i].isDigit()) stack.deleteCharAt(stack.lastIndex)
            else stack.append(s[i])
        }
        return stack.toString()
    }
}