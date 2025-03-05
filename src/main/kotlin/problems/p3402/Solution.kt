@file:Suppress("UNUSED")

package com.lvanh.problems.p3402

/**
 * Weekly Contest 430
 * Problem 3402. Minimum Operations to Make Columns Strictly Increasing
 */

class Solution {
    fun minimumOperations(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return 0
        var newGrid = grid
        var result = 0
        for (i in 1..newGrid.lastIndex) {
            for (j in newGrid[i].indices) {
                if (newGrid[i][j] > newGrid[i - 1][j]) continue
                var dif = newGrid[i - 1][j] - grid[i][j] + 1
                result += dif
                newGrid[i][j] = grid[i][j] + dif
            }
        }
        return result
    }
}
