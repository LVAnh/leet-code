@file:Suppress("UNUSED")

package com.lvanh.p1790

/**
 * Problem 1790. Check if One String Swap Can Make Strings Equal
 */
class Solution {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        var diffAt = -1
        for (i in 0..s1.lastIndex) {
            if (s1[i] == s2[i]) continue

            if (diffAt == -1) {
                diffAt = i
                continue
            }
            if (s1[i] != s2[diffAt] || s2[i] != s1[diffAt]) return false
            for (j in i + 1..s1.lastIndex) if (s1[j] != s2[j]) return false
            return true
        }
        return diffAt == -1
    }
}