@file:Suppress("UNUSED")

package com.lvanh.p50

/**
 * Problem 50. Pow(x, n)
 */

class Solution {
    fun myPow(x: Double, n: Int): Double {
        if (x == 1.0 || n == 0) return 1.0
        var x = if (n < 0) 1 / x else x
        var exp = n * if (n < 0) -1L else 1L
        var ans = 1.0
        while (exp > 0) {
            if (exp % 2 == 1L) ans *= x
            x *= x
            exp /= 2
        }
        return ans
    }
}