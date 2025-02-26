@file:Suppress("UNUSED")

package com.lvanh.p322

/**
 * Problem 322. Coin Change
 */
class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        var dp = IntArray(amount + 1) { -1 }
        dp[0] = 0
        for (i in 1..amount) {
            var minCoins = Int.MAX_VALUE
            for (coin in coins) if (i >= coin && dp[i - coin] != -1) minCoins = minOf(minCoins, dp[i - coin] + 1)
            if (minCoins != Int.MAX_VALUE) dp[i] = minCoins
        }
        return dp[amount]
    }
}


