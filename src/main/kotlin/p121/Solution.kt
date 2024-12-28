@file:Suppress("UNUSED")

package com.lvanh.p121

import kotlin.math.max

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
}