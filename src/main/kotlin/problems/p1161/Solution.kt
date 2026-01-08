@file:Suppress("UNUSED")

package com.lvanh.problems.p1161

import com.lvanh.utils.TreeNode
import java.util.LinkedList

/**
 * Problem 1161. Maximum Level Sum of a Binary Tree
 */

class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        if (root == null) return 0
        var result = 1
        val sumLevel = mutableMapOf<Int, Int>()
        fun dfs(root: TreeNode?, level: Int) {
            if (root == null) return
            sumLevel[level] = sumLevel.getOrDefault(level, 0) + root.`val`
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)
        }
        dfs(root, 1)
        var max = Integer.MIN_VALUE
        sumLevel.forEach { (level, sum) ->
            if (sum > max) {
                max = sum
                result = level
            }
        }
        return result
    }

    fun maxLevelSumBFS(root: TreeNode?): Int {
        if (root == null) return 0
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        var max = root.`val`
        var result = 1
        var currentLevel = 1
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            var sum = 0
            repeat(levelSize) {
                val node = queue.poll()
                sum += node?.`val` ?: 0
                node?.left?.let { queue.offer(it) }
                node?.right?.let { queue.offer(it) }
            }
            if (sum > max) {
                max = sum
                result = currentLevel
            }
            currentLevel++
        }
        return result
    }
}