@file:Suppress("UNUSED")

package com.lvanh.p494

import kotlin.math.abs

/**
 * Problem 494. Target Sum
 */
class Solution {
    /**
     * Dynamic Programming
     */
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        var totalSum = nums.sum()
        if (abs(target) > totalSum) return 0
        var dp = IntArray(2 * totalSum + 1)
        dp[nums[0] + totalSum] = 1
        dp[-nums[0] + totalSum] += 1
        for (i in 1 until nums.size) {
            var next = IntArray(2 * totalSum + 1)
            for (sum in -totalSum..totalSum) {
                if (dp[sum + totalSum] > 0) {
                    next[sum + nums[i] + totalSum] += dp[sum + totalSum]
                    next[sum - nums[i] + totalSum] += dp[sum + totalSum]
                }
            }
            dp = next
        }
        return dp[target + totalSum]
    }

    /**
     * Approach 1: Brute Force
     */
    fun findTargetSumWays1(nums: IntArray, target: Int): Int {
        fun backtrack(i: Int, t: Int): Int {
            if (i == nums.size - 1) {
                var res = 0
                if (nums[i] + t == 0) res++
                if (nums[i] - t == 0) res++
                return res
            }
            return backtrack(i + 1, t - nums[i]) + backtrack(i + 1, t + nums[i])
        }
        return backtrack(0, target)
    }
}