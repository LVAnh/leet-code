@file:Suppress("UNUSED")

package com.lvanh.problems.p295

import java.util.PriorityQueue

/**
 * Problem 295. Find Median from Data Stream
 */
class MedianFinder() {
    private val minHeap: PriorityQueue<Int> = PriorityQueue<Int>()
    private val maxHeap: PriorityQueue<Int> = PriorityQueue<Int>(compareByDescending { it })

    fun addNum(num: Int) {
        maxHeap.add(num)
        minHeap.add(maxHeap.poll())
        if (minHeap.size > maxHeap.size) maxHeap.add(minHeap.poll())
    }

    fun findMedian(): Double {
        return if (maxHeap.size > minHeap.size) maxHeap.peek().toDouble()
        else (maxHeap.peek() + minHeap.peek()) / 2.0
    }
}

class Solution {
    fun runTestCase(functions: Array<String>, params: Array<IntArray>): Array<Double?> {
        var obj = MedianFinder()
        var ans = Array<Double?>(params.size) { null }
        for (i in 1..functions.lastIndex) {
            if (functions[i] == "addNum") obj.addNum(params[i][0])
            if (functions[i] == "findMedian") ans[i] = obj.findMedian()
        }
        return ans
    }
}


