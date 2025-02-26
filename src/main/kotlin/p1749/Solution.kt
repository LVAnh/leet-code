@file:Suppress("UNUSED")

package com.lvanh.p1749

/**
 * Problem 1749. Maximum Absolute Sum of Any Subarray
 */

class Solution {
    fun maxAbsoluteSum(nums: IntArray): Int {
        var dpMax = IntArray(nums.size + 1) { 0 }
        var dpMin = IntArray(nums.size + 1) { 0 }
        var ans = 0
        for (i in nums.indices) {
            dpMin[i + 1] = minOf(dpMin[i] + nums[i], nums[i])
            dpMax[i + 1] = maxOf(dpMax[i] + nums[i], nums[i])
            ans = maxOf(ans, dpMax[i + 1], -dpMin[i + 1])
        }
        return ans
    }
}