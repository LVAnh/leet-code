@file:Suppress("UNUSED")

package com.lvanh.p119

/**
 * Problem 119. Pascal's Triangle II
 */

class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        val dp = MutableList<Int>(rowIndex + 1) { 1 }
        for (i in 2..rowIndex) for (j in i - 1 downTo 1) dp[j] = dp[j - 1] + dp[j]
        return dp
    }
}