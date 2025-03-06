@file:Suppress("UNUSED")

package com.lvanh.problems.p62

/**
 * Problem 62. Unique Paths
 */

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        var dp = Array<IntArray>(m) { IntArray(n) }
        for (i in 0 until m) dp[i][n - 1] = 1
        for (i in 0 until n) dp[m - 1][i] = 1
        for (i in m - 2 downTo 0) for (j in n - 2 downTo 0) dp[i][j] = dp[i][j + 1] + dp[i + 1][j]
        return dp[0][0]
    }
}
