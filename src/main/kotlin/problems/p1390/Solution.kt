@file:Suppress("UNUSED")

package com.lvanh.problems.p1390

import kotlin.math.cbrt
import kotlin.math.roundToInt
import kotlin.math.sqrt


/**
 * Problem 1390. Four Divisors
 */

class Solution {
    fun sumFourDivisors(nums: IntArray): Int {
        // Sieve of Eratosthenes
        val maxVal = nums.maxOrNull() ?: return 0
        val isPrime = BooleanArray(maxVal + 1) { true }
        isPrime[0] = false
        isPrime[1] = false
        for (i in 2..sqrt(maxVal.toDouble()).toInt()) {
            if (isPrime[i]) {
                for (j in i * i..maxVal step i) {
                    isPrime[j] = false
                }
            }
        }
        var result = 0
        for (n in nums) {
            if (n < 2) continue
            val cubeRoot = cbrt(n.toDouble()).roundToInt()
            if (cubeRoot * cubeRoot * cubeRoot == n && cubeRoot > 1 && isPrime[cubeRoot]) {
                result += 1 + cubeRoot + cubeRoot * cubeRoot + n
                continue
            }
            for (i in 2..sqrt(n.toDouble()).roundToInt()) {
                if (isPrime[i] && n % i == 0 && isPrime[n / i] && i != n / i) {
                    result += n / i + i + n + 1
                    break
                }
            }
        }
        return result
    }
}