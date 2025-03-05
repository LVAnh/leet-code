@file:Suppress("UNUSED")

package com.lvanh.problems.p1524

/**
 * Problem 1524. Number of Sub-arrays With Odd Sum
 */

class Solution {
    fun numOfSubarrays(arr: IntArray): Int {
        val MOD = 1_000_000_007
        var dpEven = IntArray(arr.size + 1)
        var dpOdd = IntArray(arr.size + 1)
        var res = 0
        for (i in 0 until arr.size) {
            if (arr[i] % 2 == 0) {
                dpEven[i + 1] = dpEven[i] + 1
                dpOdd[i + 1] = dpOdd[i]
            } else {
                dpEven[i + 1] = dpOdd[i]
                dpOdd[i + 1] = dpEven[i] + 1
            }
            res = (res + dpOdd[i + 1]) % MOD
        }
        return res
    }
}