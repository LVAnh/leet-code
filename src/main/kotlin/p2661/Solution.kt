@file:Suppress("UNUSED")

package com.lvanh.p2661

/**
 * Problem 2661. First Completely Painted Row or Column
 */
class Solution {
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        var hashRow = mutableMapOf<Int, Int>()
        var hashCol = mutableMapOf<Int, Int>()
        var hashPosition = mutableMapOf<Int, Pair<Int, Int>>()
        val m = mat.size
        val n = mat[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                hashPosition[mat[i][j]] = Pair(i, j)
            }
        }
        for (i in arr.indices) {
            hashPosition[arr[i]]?.let {
                hashRow[it.first] = (hashRow[it.first] ?: 0) + 1
                hashCol[it.second] = (hashCol[it.second] ?: 0) + 1
                if (hashRow[it.first] == n || hashCol[it.second] == m) return i
            }
        }
        return -1
    }
}
