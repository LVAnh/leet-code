@file:Suppress("UNUSED")

package com.lvanh.problems.p509

/**
 * Problem 509. Fibonacci Number
 */
class Solution {
    fun fib(n: Int): Int {
        if (n <= 1) return n
        var dp = IntArray(n + 1)
        dp[0] = 0
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        return dp[n]
    }
}
