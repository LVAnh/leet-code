@file:Suppress("UNUSED")

package com.lvanh.problems.p3208

/**
 * Problem 3208. Alternating Groups II
 */
class Solution {
    fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
        val n = colors.size
        var ans = 0
        var start = 0
        for (i in 1 until n + k - 1) {
            if (colors[i % n] == colors[(i - 1) % n]) start = i
            if (i - start + 1 >= k) ans++
        }
        return ans
    }
}