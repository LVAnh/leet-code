@file:Suppress("UNUSED")

package com.lvanh.p2460

/**
 * Problem 2460. Apply Operations to an Array
 */
class Solution {
    fun applyOperations(nums: IntArray): IntArray {
        var out = IntArray(nums.size) { 0 }
        var first = 0
        var i = 0
        while (i < nums.size - 1) {
            if (nums[i] == 0) i++
            else if (nums[i] == nums[i + 1]) {
                out[first++] = 2 * nums[i]
                i += 2
            } else out[first++] = nums[i++]
        }
        if (i < nums.size) out[first] = nums[i]
        return out
    }
}
