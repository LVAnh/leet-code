@file:Suppress("UNUSED")

package com.lvanh.problems.p26

/**
 * Problem 26. Remove Duplicates from Sorted Array
 */

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var k = 1
        for (i in 1 until nums.size) if (nums[i] != nums[i - 1]) nums[k++] = nums[i]
        return k
    }
}
