@file:Suppress("UNUSED")

package com.lvanh.problems.p3456

/**
 * Problem 3456. Find Special Substring of Length K
 */

class Solution {
    fun hasSpecialSubstring(s: String, k: Int): Boolean {
        if (k > s.length) return false
        var start = 0
        for (i in 1 until s.length) {
            if (s[i] != s[start]) {
                if (i - start == k) return true
                start = i
            }
        }
        return s.length - start == k
    }
}
