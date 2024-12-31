@file:Suppress("UNUSED")

package com.lvanh.p983

/**
 * Problem 983. Minimum Cost For Tickets
 */
class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        var dp = IntArray(days.last() + 1) { 0 }
        var realCosts = arrayOf(minOf(costs[0], costs[1], costs[2]), minOf(costs[1], costs[2]))
        var i = 0
        for (day in days.first()..days.last()) {
            if (day < days[i]) dp[day] = dp[day - 1]
            else {
                i++
                var dp0 = dp[day - 1] + realCosts[0]
                var dp1 = dp[maxOf(day - 7, 0)] + realCosts[1]
                var dp2 = dp[maxOf(day - 30, 0)] + costs[2]
                dp[day] = minOf(dp0, dp1,dp2)
            }
        }
        return dp[days.last()]
    }
}