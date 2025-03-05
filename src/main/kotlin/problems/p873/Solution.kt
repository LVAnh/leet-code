@file:Suppress("UNUSED")

package com.lvanh.problems.p873

/**
 * Problem 873. Length of Longest Fibonacci Subsequence
 */

class Solution {
    fun lenLongestFibSubseq(arr: IntArray): Int {
        var dp = Array<IntArray>(arr.size) { IntArray(arr.size) { 0 } }
        var hashtable = hashMapOf<Int, Int>()
        var max = 0
        for (i in arr.indices) {
            hashtable[arr[i]] = i
            for (j in 0..i - 1) {
                dp[i][j] = 2
                var k = hashtable[arr[i] - arr[j]]
                if (k == null || k >= j) continue
                dp[i][j] = maxOf(dp[i][j], dp[j][k] + 1)
                max = maxOf(dp[i][j], max)
            }
        }
        return if (max > 2) max else 0
    }
}