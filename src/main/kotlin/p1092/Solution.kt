@file:Suppress("UNUSED")

package com.lvanh.p1092

/**
 * Problem 1092. Shortest Common Supersequence
 */
class Solution {
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        var row = str1.length
        var col = str2.length
        var dp = Array<IntArray>(row + 1) { IntArray(col + 1) { it } }
        for (i in 1..row) {
            dp[i][0] = i
            for (j in 1..col) {
                dp[i][j] = 1 + if (str1[i - 1] == str2[j - 1]) dp[i - 1][j - 1] else minOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
        var ans = StringBuilder()
        while (row > 0 && col > 0) {
            if (str1[row - 1] == str2[col - 1]) {
                ans.append(str1[--row])
                --col
            } else if (dp[row - 1][col] < dp[row][col - 1]) ans.append(str1[--row])
            else ans.append(str2[--col])
        }
        while (row > 0) ans.append(str1[--row])
        while (col > 0) ans.append(str2[--col])
        return ans.toString().reversed()
    }
}