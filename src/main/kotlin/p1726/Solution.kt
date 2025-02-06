@file:Suppress("UNUSED")

package com.lvanh.p1726

/**
 * Problem 1726. Tuple with Same Product
 *
 */

class Solution {
    fun tupleSameProduct(nums: IntArray): Int {
        val hashTable = hashMapOf<Int, Int>()
        for (i in nums.indices) {
            for (j in i + 1..nums.lastIndex) hashTable[nums[i] * nums[j]] = (hashTable[nums[i] * nums[j]] ?: 0) + 1
        }
        var ans = 0
        //C(k,2)=0.5*k*(k-1)
        for (k in hashTable.values) ans += 4 * k * (k - 1)
        return ans
    }
}