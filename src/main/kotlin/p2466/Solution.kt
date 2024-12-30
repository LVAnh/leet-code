@file:Suppress("UNUSED")

package com.lvanh.p2466

/**
 * Problem 2466. Count Ways To Build Good Strings
 */
class Solution {
    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        var mod = 1_000_000_007
        var dp = IntArray(high + 1) { 0 }
        dp[0] = 1
        for (i in 0..high) {
            if (zero <= i) dp[i] += dp[i - zero]
            if (one <= i) dp[i] += dp[i - one]
            dp[i] %= mod
        }
        var result = 0
        for (dpi in low..high) {
            result += dp[dpi]
            result %= mod
        }
        return result
    }
}
