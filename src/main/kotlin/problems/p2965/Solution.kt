@file:Suppress("UNUSED")

package com.lvanh.problems.p2965

/**
 * Problem 2965. Find Missing and Repeated Values
 */
class Solution {
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        var n = grid.size
        var hashtable = IntArray(n * n + 1)
        var ans = IntArray(2)
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                hashtable[grid[i][j]] += 1
                if (hashtable[grid[i][j]] == 2) ans[0] = grid[i][j]
            }
        }
        for (i in 1..n * n) if (hashtable[i] == 0) {
            ans[1] = i
            break
        }
        return ans
    }
}