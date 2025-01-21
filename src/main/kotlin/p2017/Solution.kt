@file:Suppress("UNUSED")

package com.lvanh.p2017

/**
 * Problem 2017. Grid Game
 */
class Solution {
    fun gridGame(grid: Array<IntArray>): Long {
        var n = grid[0].size
        var sum1: Long = 0
        var sum2: Long = 0
        for (i in 0 until n) sum1 += grid[0][i]
        var path = sum1 - grid[0][0]
        for (i in 0 until n) {
            sum1 -= grid[0][i]
            path = minOf(maxOf(sum1, sum2), path)
            sum2 += grid[1][i]
        }
        return path
    }
}
