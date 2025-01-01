@file:Suppress("UNUSED")

package com.lvanh.p3

/**
 * Problem 3. Longest Substring Without Repeating Characters
 */
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        var hashtable = mutableMapOf<Char, Int>()
        var left = 0
        var right = 0
        var max = 1
        for (i in 0 until s.length) {
            hashtable[s[i]]?.let { if (it >= left) left = it + 1 }
            right++
            max = maxOf(right - left, max)
            hashtable[s[i]] = i
        }
        return max
    }
}
