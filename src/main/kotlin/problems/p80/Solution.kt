@file:Suppress("UNUSED")

package com.lvanh.problems.p80

/**
 * Problem 80. Remove Duplicates from Sorted Array II
 */
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size
        var k = 2
        for (i in 2 until nums.size) if (nums[k - 2] != nums[i]) nums[k++] = nums[i]
        return k
    }
}