@file:Suppress("UNUSED")

package com.lvanh.problems.p118

/**
 * Problem 118. Pascal's Triangle
 */

class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val dp = List(numRows) { row -> MutableList(row + 1) { 1 } }
        for (i in 1 until numRows) {
            for (j in 1 until i) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        }
        return dp
    }
}