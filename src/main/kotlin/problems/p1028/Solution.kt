@file:Suppress("UNUSED")

package com.lvanh.problems.p1028

import com.lvanh.utils.TreeNode

/**
 * Problem 1028. Recover a Tree From Preorder Traversal
 */
class Solution {
    fun recoverFromPreorder(traversal: String): TreeNode? {
        var index = 0
        fun dfs(level: Int): TreeNode? {
            var i = index
            while (i < traversal.length && traversal[i] != '-') i++
            var node: TreeNode? = TreeNode(traversal.substring(index, i).toInt())
            index = i
            while (i < traversal.length && traversal[i] == '-') i++
            if (i - index == level + 1) {
                index = i
                node?.left = dfs(level + 1)
            }
            i = index
            while (i < traversal.length && traversal[i] == '-') i++
            if (i - index == level + 1) {
                index = i
                node?.right = dfs(level + 1)
            }
            return node
        }
        return dfs(0)
    }
}