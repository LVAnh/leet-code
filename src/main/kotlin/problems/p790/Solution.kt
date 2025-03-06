@file:Suppress("UNUSED")

package com.lvanh.problems.p790

/**
 * Problem 790. Domino and Tromino Tiling
 */
class Solution {
    fun numTilings(n: Int): Int {
        var mod = 1_000_000_007
        var dp = LongArray(n + 3)
        dp[1] = 1
        dp[2] = 2
        dp[3] = 5
        for (i in 4..n) dp[i] = (dp[i - 3] + 2 * dp[i - 1]) % mod
        return dp[n].toInt()
    }
}
