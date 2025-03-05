@file:Suppress("UNUSED")

package com.lvanh.problems.p1910

/**
 * Problem 1910. Remove All Occurrences of a Substring
 */
class Solution {
    fun removeOccurrences(s: String, part: String): String {
        var stack = StringBuilder()
        for (i in s.indices) {
            stack.append(s[i])
            while (stack.length >= part.length &&stack.substring(stack.length-part.length) == part) {
                stack.setLength(stack.length-part.length)
            }
        }
        return stack.toString()
    }
}