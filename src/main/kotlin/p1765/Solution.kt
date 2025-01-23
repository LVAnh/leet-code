@file:Suppress("UNUSED")

package com.lvanh.p1765

import java.util.LinkedList
import java.util.Queue

/**
 * Problem 1765. Map of Highest Peak
 */

class Solution {
    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        var queue: Queue<Pair<Int, Int>> = LinkedList()
        var result = Array<IntArray>(isWater.size) { IntArray(isWater[0].size) { -1 } }
        for (i in isWater.indices) {
            for (j in isWater[i].indices) {
                if (isWater[i][j] == 1) {
                    queue.add(Pair(i, j))
                    result[i][j] = 0
                }
            }
        }
        while (queue.isNotEmpty()) {
            var (i, j) = queue.poll()
            if (i - 1 >= 0 && result[i - 1][j] < 0) {
                result[i - 1][j] = result[i][j] + 1
                queue.add(Pair(i - 1, j))
            }
            if (j - 1 >= 0 && result[i][j - 1] < 0) {
                result[i][j - 1] = result[i][j] + 1
                queue.add(Pair(i, j - 1))

            }
            if (i + 1 < result.size && result[i + 1][j] < 0) {
                result[i + 1][j] = result[i][j] + 1
                queue.add(Pair(i + 1, j))
            }

            if (j + 1 < result[0].size && result[i][j + 1] < 0) {
                result[i][j + 1] = result[i][j] + 1
                queue.add(Pair(i, j + 1))
            }
        }
        return result
    }
}