@file:Suppress("UNUSED")

package com.lvanh.p300

/**
 * Problem 300. Longest Increasing Subsequence
 */
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1 }
        var ans = 1
        for (i in 1 until nums.size) {
            for (j in i - 1 downTo 0) if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1
            ans = maxOf(ans, dp[i])
        }
        return ans
    }
}


