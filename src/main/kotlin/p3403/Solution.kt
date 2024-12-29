@file:Suppress("UNUSED")

package com.lvanh.p3403

/**
 * Weekly Contest 430
 * Problem 3403. Minimum Operations to Make Columns Strictly Increasing
 */

class Solution {
    fun answerString(word: String, numFriends: Int): String {
        if (numFriends == 1) return word
        var windowSize = word.length - numFriends + 1
        var box = hashSetOf<String>()
        var window = arrayListOf<Char>()
        for (i in 0..word.lastIndex + windowSize - 1) {
            if (i < word.length) window.add(word[i])
            if (i >= windowSize) window.removeFirst()
            var subWord = String(window.toCharArray())
            box.add(subWord)
        }
        var result = box.first()
        for (subWord in box) if (subWord > result) result = subWord
        return result
    }
}
