@file:Suppress("UNUSED")

package com.lvanh.problems.p1137

/**
 * Problem 1137. N-th Tribonacci Number
 */
class Solution {
    fun tribonacci(n: Int): Int {
        var dp = IntArray(n + 1) { 1 }
        dp[0] = 0
        for (i in 3..n) dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
        return dp[n]
    }
}