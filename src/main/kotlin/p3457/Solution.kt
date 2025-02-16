@file:Suppress("UNUSED")

package com.lvanh.p3457


/**
 * Problem 3457. Eat Pizzas!
 */

class Solution {
    fun maxWeight(pizzas: IntArray): Long {
        var days = pizzas.size / 4
        var odd = if (days % 2 == 0) days / 2 else (days + 1) / 2
        var even = if (days % 2 == 0) days / 2 else (days - 1) / 2
        pizzas.sort()
        var ans = 0L
        var i = pizzas.lastIndex
        while (odd > 0 || even > 0) {
            if (odd > 0) {
                ans += pizzas[i]
                odd--
                i--
            } else {
                ans += pizzas[i - 1]
                even--
                i = i - 2
            }

        }
        return ans
    }
}
