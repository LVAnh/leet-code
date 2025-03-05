@file:Suppress("UNUSED")

package com.lvanh.problems.p121

/**
 * Problem 121. Best Time to Buy and Sell Stock
 */
class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0
        var maxProfit = 0
        var minPrice = Int.MAX_VALUE
        for (price in prices) {
            if (price < minPrice) minPrice = price
            else if (price - minPrice > maxProfit) maxProfit = price - minPrice
        }
        return maxProfit
    }

    fun maxProfitDP(prices: IntArray): Int {
        if (prices.isEmpty()) return 0
        var dp = IntArray(prices.size) { 0 }
        var bestSell = IntArray(prices.size) { prices.size - 1 }
        var maxProfit = 0
        for (i in prices.size - 2 downTo 0) {
            if (prices[bestSell[i + 1]] >= prices[i]) bestSell[i] = bestSell[i + 1]
            else bestSell[i] = i
            dp[i] = prices[bestSell[i]] - prices[i]
            maxProfit = maxOf(dp[i], maxProfit)
        }
        return maxProfit
    }
}