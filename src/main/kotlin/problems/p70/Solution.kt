@file:Suppress("UNUSED")

package com.lvanh.problems.p70

/**
 * Problem 70. Climbing Stairs
 */
class Solution {
    fun climbStairs(n: Int): Int {
        if (n <= 1) return 1
        var dp = IntArray(n)
        dp[n - 1] = 1
        dp[n - 2] = 2
        for (i in n - 3 downTo 0) {
            dp[i] = dp[i + 1] + dp[i + 2]
        }
        return dp[0]
    }
}
