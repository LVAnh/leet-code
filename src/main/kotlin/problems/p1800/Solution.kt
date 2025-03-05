@file:Suppress("UNUSED")

package com.lvanh.problems.p1800

/**
 * Problem 1800. Maximum Ascending Subarray Sum
 */
class Solution {
    fun maxAscendingSum(nums: IntArray): Int {
        var sum = nums[0]
        var answer = sum
        for (i in 1..nums.lastIndex) {
            sum = if (nums[i] > nums[i - 1]) sum + nums[i] else nums[i]
            answer = maxOf(sum, answer)
        }
        return answer
    }
}