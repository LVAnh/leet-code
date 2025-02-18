@file:Suppress("UNUSED")

package com.lvanh.p2375

import java.util.Stack

/**
 * Problem 2375. Construct Smallest Number From DI String
 */
class Solution {
    fun smallestNumber(pattern: String): String {
        val result = StringBuilder()
        val numStack = Stack<Int>()
        for (index in 0..pattern.length) {
            numStack.add(index + 1)
            if (index == pattern.length || pattern[index] == 'I') {
                while (numStack.isNotEmpty()) result.append(numStack.pop())
            }
        }
        return result.toString()
    }
}

