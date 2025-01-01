@file:Suppress("UNUSED")

package com.lvanh.p1422

/**
 * Problem 1422. Maximum Score After Splitting a String
 */
class Solution {
    fun maxScore(s: String): Int {
        if (s.length < 2) return 0
        var number1 = s.count { it == '1' }
        var count0 = 0
        var count1 = 0
        var max = 0
        for (i in 0 until s.length - 1) {
            if (s[i] == '0') count0++ else count1++
            max = maxOf(max, count0 + number1 - count1)
        }
        return max
    }
}