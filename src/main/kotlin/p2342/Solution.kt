@file:Suppress("UNUSED")

package com.lvanh.p2342

/**
 * Problem 2342. Max Sum of a Pair With Equal Sum of Digits
 */
class Solution {
    fun maximumSum(nums: IntArray): Int {
        var hashtable = IntArray(82) { 0 }
        var ans = -1
        for (num in nums) {
            val digits = num.digits()
            var max = num
            if(hashtable[digits]>0){
                ans = maxOf(hashtable[digits] + num, ans)
                max = maxOf(hashtable[digits], num)
            }
            hashtable[digits] = max
        }
        return ans
    }

    private fun Int.digits(): Int {
        var num = this
        var digits = 0
        while (num > 0) {
            digits += num % 10
            num /= 10
        }
        return digits
    }
}
