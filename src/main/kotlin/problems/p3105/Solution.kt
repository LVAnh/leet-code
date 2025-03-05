@file:Suppress("UNUSED")

package com.lvanh.problems.p3105

/**
 * Problem 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
 */
class Solution {
    fun longestMonotonicSubarray(nums: IntArray): Int {
        var max = 1
        var dec = 1
        var inc = 1
        for (i in 1..nums.lastIndex) {
            if (nums[i] > nums[i - 1]) {
                inc++
                dec = 1
            } else if (nums[i] < nums[i - 1]) {
                dec++
                inc = 1
            } else {
                dec = 1
                inc = 1
            }
            max = maxOf(max, inc, dec)
        }
        return max
    }
}
