@file:Suppress("UNUSED")

package com.lvanh.problems.p1975

import kotlin.math.abs

/**
 * Problem 1975. Maximum Matrix Sum
 */
class Solution {
    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var sum = 0L
        var nav = 0
        var min = abs(matrix[0][0])
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                val abs = abs(matrix[i][j])
                if (abs < min) min = abs
                if (matrix[i][j] < 0) nav++
                sum += abs
            }
        }
        if (nav % 2 == 0) return sum
        return sum - 2 * min
    }
}