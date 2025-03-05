@file:Suppress("UNUSED")

package com.lvanh.problems.p1267

/**
 * Problem 1267. Count Servers that Communicate
 */
class Solution {
    fun countServers(grid: Array<IntArray>): Int {
        var m = grid.size
        var n = grid[0].size
        var rows = IntArray(m) { 0 }
        var cols = IntArray(n) { 0 }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    rows[i] += grid[i][j]
                    cols[j] += grid[i][j]
                }
            }
        }
        var result = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) result++
            }
        }
        return result
    }
}