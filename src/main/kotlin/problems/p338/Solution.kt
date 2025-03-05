@file:Suppress("UNUSED")

package com.lvanh.problems.p338

/**
 * Problem 338. Counting Bits
 */
class Solution {
    fun countBits(n: Int): IntArray {
        var dp = IntArray(n + 1)
        for (i in 0..n) dp[i] = dp[i.shr(1)] + (i and 1)
        return dp
    }
}
