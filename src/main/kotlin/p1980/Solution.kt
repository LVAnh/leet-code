@file:Suppress("UNUSED")

package com.lvanh.p1980

/**
 * Problem 1980. Find Unique Binary String
 */
class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val ans = StringBuilder()
        for (i in nums.indices) ans.append(if (nums[i][i] == '1') '0' else '1')
        return ans.toString()
    }
}