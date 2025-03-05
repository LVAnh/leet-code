@file:Suppress("UNUSED")

package com.lvanh.problems.p198

/**
 * Problem 198. House Robber
 */
class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = maxOf(nums[1], nums[0])
        for (i in 2 until nums.size) dp[i] = maxOf(dp[i - 2] + nums[i], dp[i - 1])
        return dp[nums.size - 1]
    }
}