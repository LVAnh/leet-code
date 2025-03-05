@file:Suppress("UNUSED")

package com.lvanh.problems.p188

/**
 * Problem 188. Best Time to Buy and Sell Stock IV
 */
class Solution {
    fun maxProfit(k: Int, prices: IntArray): Int {
        var dp = Array<IntArray>(prices.size) { IntArray(k+1)  }
        for (j in 1..k){
            var maxProfit = -prices[0]
            for (i in 1 until prices.size) {
                dp[i][j] = maxOf(dp[i - 1][j], prices[i] + maxProfit)
                maxProfit = maxOf(maxProfit, dp[i - 1][j - 1] - prices[i])
            }
        }
        return dp[prices.size - 1][k]
    }
}