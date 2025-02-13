@file:Suppress("UNUSED")

package com.lvanh.p3066

import java.util.PriorityQueue

/**
 * Problem 3066. Minimum Operations to Exceed Threshold Value II
 */
class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        var ans = 0
        var queue = PriorityQueue<Long>()
        for (num in nums) queue.add(num.toLong())
        while (queue.size > 1 && queue.peek() < k) {
            var x = queue.poll()
            var y = queue.poll()
            queue.add(x * 2 + y)
            ans++
        }
        return ans
    }
}
