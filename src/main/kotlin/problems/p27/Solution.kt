@file:Suppress("UNUSED")

package com.lvanh.problems.p27

/**
 * Problem 27. Remove Element
 */

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0
        for (i in nums.indices) if (nums[i] != `val`) nums[k++] = nums[i]
        return k
    }
}
