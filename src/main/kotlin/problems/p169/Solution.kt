@file:Suppress("UNUSED")

package com.lvanh.problems.p169

/**
 * Problem 169. Majority Element
 */
class Solution {
    fun majorityElement(nums: IntArray): Int {
        var majority = nums[0]
        var votes = 0
        for (i in 0..<nums.size) {
            if (votes == 0) {
                majority = nums[i]
                votes = 1
            } else if (nums[i] == majority) votes++ else votes--
        }
        return majority
    }
}