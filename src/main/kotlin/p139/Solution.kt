@file:Suppress("UNUSED")

package com.lvanh.p139

/**
 * Problem 139. Word Break
 */
class Solution {
    fun wordBreak(s: String, wordDict: Array<String>): Boolean {
        val hashSet = hashSetOf<String>()
        var maxLength = 0
        for (word in wordDict) {
            hashSet.add(word)
            maxLength = maxOf(maxLength, word.length)
        }
        var dp = BooleanArray(s.length + 1) { false }
        dp[0] = true
        for (i in s.indices) {
            var start = maxOf(0, i - maxLength + 1)
            for (j in start..i) {
                if (dp[j] && hashSet.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true
                    break
                }
            }
        }
        return dp[s.length]
    }
}