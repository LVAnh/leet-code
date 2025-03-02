@file:Suppress("UNUSED")

package com.lvanh.p746

/**
 * Problem 746. Min Cost Climbing Stairs
 */
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var n = cost.size
        var dp = IntArray(n + 1) { 0 }
        dp[1] = cost[0]
        for (i in 1 until n) dp[i + 1] = minOf(dp[i], dp[i - 1]) + cost[i]
        return minOf(dp[n], dp[n - 1])
    }
}
