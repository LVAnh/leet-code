@file:Suppress("UNUSED")

package com.lvanh.problems.p392

/**
 * Problem 392. Is Subsequence
 */
class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var left = 0
        for (i in t.indices) {
            if (left >= s.length) return true
            if (s[left] == t[i]) left++
        }
        return left == s.length
    }
}


