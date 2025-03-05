@file:Suppress("UNUSED")

package com.lvanh.problems.p189

/**
 * Problem 189. Rotate Array
 */
class Solution {
    fun rotate(nums: IntArray, k: Int): IntArray {
        var nk = k % nums.size
        var tmp = IntArray(nk)
        for (i in tmp.indices) tmp[i] = nums[nums.size - nk + i]
        for (i in nums.size - 1 downTo nk) nums[i] = nums[i - nk]
        for (i in tmp.indices) nums[i] = tmp[i]
        return nums
    }
}