@file:Suppress("UNUSED")

package com.lvanh.p3160

/**
 * Problem 3160. Find the Number of Distinct Colors Among the Balls
 */
class Solution {
    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
        var hashTable = hashMapOf<Int, Int>()
        var colors = hashMapOf<Int, Int>()
        var answer = IntArray(queries.size) { 0 }
        for (i in queries.indices) {
            var incColor = 0
            if (colors[queries[i][0]] != 0) {
                var newValue = (hashTable[colors[queries[i][0]]] ?: 0) - 1
                hashTable[colors[queries[i][0]] ?: 0] = newValue
                if (newValue == 0) incColor--
            }
            if ((hashTable[queries[i][1]] ?: 0) == 0) incColor++
            answer[i] = answer[maxOf(i - 1, 0)] + incColor
            colors[queries[i][0]] = queries[i][1]
            hashTable[queries[i][1]] = (hashTable[queries[i][1]] ?: 0) + 1
        }
        return answer
    }
}
