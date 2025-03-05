@file:Suppress("UNUSED")

package com.lvanh.problems.p1079

/**
 * Problem 1079. Letter Tile Possibilities
 */
class Solution {
    fun numTilePossibilities(tiles: String): Int {
        val count = IntArray(26)
        for (char in tiles) count[char - 'A']++
        fun dfs(): Int {
            var ans = 0
            for (i in count.indices) if (count[i] > 0) {
                count[i]--
                ans += dfs() + 1
                count[i]++
            }
            return ans
        }
        return dfs()
    }
}