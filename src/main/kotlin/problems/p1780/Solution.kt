@file:Suppress("UNUSED")

package com.lvanh.problems.p1780

/**
 * Problem 1780. Check if Number is a Sum of Powers of Three
 */

class Solution {
    fun checkPowersOfThree(n: Int): Boolean {
        var n = n
        var powThrees = IntArray(15) { 1 }
        for (i in 1..powThrees.size - 1) powThrees[i] = 3 * powThrees[i - 1]
        for (i in 14 downTo 0) {
            if (n == powThrees[i]) return true
            if (n > 2 * powThrees[i]) return false
            n %= powThrees[i]
        }
        return false
    }
}