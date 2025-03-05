@file:Suppress("UNUSED")

package com.lvanh.problems.p2467

/**
 * Problem 2467. Most Profitable Path in a Tree
 */
class Solution {
    fun mostProfitablePath(edges: Array<IntArray>, bob: Int, amount: IntArray): Int {
        var rootTable = hashMapOf<Int, ArrayList<Int>>()
        for (i in edges.indices) {
            var current = rootTable[edges[i][0]] ?: arrayListOf()
            current.add(edges[i][1])
            rootTable[edges[i][0]] = current
            current = rootTable[edges[i][1]] ?: arrayListOf()
            current.add(edges[i][0])
            rootTable[edges[i][1]] = current
        }
        var bobPath = ArrayList<Int>()
        fun bobDfs(node: Int, ignore: Int): Boolean {
            if (node == 0) return true
            rootTable[node]!!.forEach { if (it != ignore && bobDfs(it, node)) return bobPath.add(it) }
            return false
        }
        bobDfs(bob, -1)
        bobPath.add(bob)
        var halfBobPath = bobPath.size / 2
        if (bobPath.size % 2 == 1) amount[bobPath[halfBobPath]] = amount[bobPath[halfBobPath++]] / 2
        for (i in halfBobPath..bobPath.size - 1) amount[bobPath[i]] = 0
        fun dfs(node: Int, ignoreNode: Int): Int {
            var max: Int? = null
            rootTable[node]?.forEach {
                if (it != ignoreNode) {
                    var next = dfs(it, node)
                    if ((max ?: Int.MIN_VALUE) < next) max = next
                }
            }
            return (max ?: 0) + amount[node]
        }
        return dfs(0, -1)
    }
}
