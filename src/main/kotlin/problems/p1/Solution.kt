@file:Suppress("UNUSED")

package com.lvanh.problems.p1

/**
 * Problem 1. Two Sum
 */
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement) && map[complement] != i) {
                return intArrayOf(i, map.getValue(complement))
            }
            map.put(nums[i], i)
        }
        return intArrayOf()
    }
}
