@file:Suppress("UNUSED")

package com.lvanh.problems.p123

/**
 * Problem 123. Best Time to Buy and Sell Stock III
 */
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var dp = Array<IntArray>(prices.size) { IntArray(3)  }
        for (j in 1..2){
            var maxProfit = -prices[0]
            for (i in 1 until prices.size) {
                dp[i][j] = maxOf(dp[i - 1][j], prices[i] + maxProfit)
                maxProfit = maxOf(maxProfit, dp[i - 1][j - 1] - prices[i])
            }
        }
        return dp[prices.size - 1][2]
    }
}