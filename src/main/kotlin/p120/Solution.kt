@file:Suppress("UNUSED")

package com.lvanh.p120

/**
 * Problem 120. Triangle
 */

class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        var dp = MutableList<Array<Int>>(triangle.size) { Array(it + 1) { triangle[0][0] } }
        for (i in 1 until triangle.size) {
            dp[i][0] = triangle[i][0] + dp[i - 1][0]
            for (j in 1 until triangle[i].size) {
                dp[i][j] = triangle[i][j] + minOf(dp[i - 1][minOf(j, triangle[i - 1].size-1)], dp[i - 1][j - 1])
            }
        }
        var ans = Int.MAX_VALUE
        for (i in 0 until triangle.size) ans = minOf(ans, dp[dp.size - 1][i])
        return ans
    }
}