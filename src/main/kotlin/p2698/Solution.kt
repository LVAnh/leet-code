@file:Suppress("UNUSED")

package com.lvanh.p2698

/**
 * Problem 2698. Find the Punishment Number of an Integer
 */
class Solution {
    fun punishmentNumber(n: Int): Int {
        var ans = 1

        fun checkPunishment(value: Int, target: Int): Boolean {
            if (value == target) return true
            if (target < 0 || value < target) return false
            var length = 10
            while (value / length > 0) {
                if (checkPunishment(value / length, target - value % length)) return true
                length *= 10
            }
            return false
        }
        for (i in 2..n) {
            if (checkPunishment(i * i, i)) ans += i * i
        }
        return ans
    }
}