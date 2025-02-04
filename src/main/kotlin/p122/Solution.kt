@file:Suppress("UNUSED")

package com.lvanh.p122


/**
 * Problem 122. Best Time to Buy and Sell Stock II
 */
class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0
        var dp = IntArray(prices.size + 1) { 0 }
        var shouldSell = IntArray(prices.size) { prices.size - 1 }
        var lastBuy = prices.size
        for (i in prices.size - 2 downTo 0) {
            if (prices[i] > prices[i + 1]) lastBuy = i + 1
            if (prices[shouldSell[i + 1]] >= prices[i] && lastBuy > i + 1) shouldSell[i] = shouldSell[i + 1]
            else shouldSell[i] = i
            dp[i] = prices[shouldSell[i]] - prices[i] + dp[lastBuy]
        }
        return dp[0]
    }
}