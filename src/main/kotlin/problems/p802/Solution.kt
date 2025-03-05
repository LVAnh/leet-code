@file:Suppress("UNUSED")

package com.lvanh.problems.p802

/**
 * Problem 802. Find Eventual Safe States
 */

class Solution {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        var visits = Array<Boolean>(graph.size) { false }
        var inStack = Array<Boolean>(graph.size) { false }
        fun dfs(node: Int): Boolean {
            if (inStack[node]) return true
            if (visits[node]) return false
            visits[node] = true
            inStack[node] = true
            for (next in graph[node]) if (dfs(next)) return true
            inStack[node] = false
            return false
        }
        for (i in graph.indices) dfs(i)
        var safes = arrayListOf<Int>()
        for (i in graph.indices) if (!inStack[i]) safes.add(i)
        return safes
    }
}
