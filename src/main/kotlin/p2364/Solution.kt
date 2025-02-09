@file:Suppress("UNUSED")

package com.lvanh.p2364

/**
 * Problem 2364. Count Number of Bad Pairs
 */
class Solution {
    fun countBadPairs(nums: IntArray): Long {
        var goodPairs = 0L
        var hashtable = hashMapOf<Int, Int>()
        for (i in nums.indices) hashtable[nums[i] - i] = hashtable.getOrDefault(nums[i] - i, 0) + 1
        for (value in hashtable.values) if (value > 1) goodPairs += 1L * value * (value - 1) / 2
        var badPairs = 1L * nums.size * (nums.size - 1) / 2 - goodPairs
        return badPairs
    }
}
