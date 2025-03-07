@file:Suppress("UNUSED")

package com.lvanh.problems.p2523

import kotlin.math.sqrt

/**
 * Problem 2523. Closest Prime Numbers in Range
 */
class Solution {
    fun closestPrimes(left: Int, right: Int): IntArray {
        var left = maxOf(left, 2)
        var sieve = SievePrime(right)
        var ans = IntArray(2) { -right }
        ans[1] = right
        var pre = -right
        for (i in left..right) {
            if (sieve.isPrime(i)) {
                if (i - pre < ans[1] - ans[0]) {
                    ans[0] = pre
                    ans[1] = i
                }
                pre = i
            }
        }
        return if (ans[0] > 0) ans else intArrayOf(-1, -1)
    }
}

class SievePrime {
    val n: Int
    var primes: IntArray

    constructor(n: Int) {
        this.n = n
        this.primes = IntArray(n + 1) { it }
        for (i in 2..sqrt(n + 1.0).toInt()) {
            if (primes[i] == i) {
                var j = i
                while (i * j < n + 1) primes[i * j] = j++
            }
        }
    }

    fun isPrime(n: Int): Boolean = n == primes[n]
}
