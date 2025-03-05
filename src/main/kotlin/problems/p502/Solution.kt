@file:Suppress("UNUSED")

package com.lvanh.problems.p502

import java.util.PriorityQueue

/**
 * Problem 502. IPO
 */
class Solution {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        var ans = w
        var minCapital = PriorityQueue<Int>(compareBy { capital[it] })
        var maxProfits = PriorityQueue<Int>(compareByDescending { profits[it] })
        for (i in capital.indices) minCapital.add(i)
        var ki = k
        while (ki > 0) {
            if (minCapital.isEmpty() || capital[minCapital.peek()] > ans) {
                if (maxProfits.isEmpty()) return ans
                ans += profits[maxProfits.poll()]
                ki--
            }
            if (minCapital.isNotEmpty() && capital[minCapital.peek()] <= ans) maxProfits.offer(minCapital.poll())
        }
        return ans
    }
}
