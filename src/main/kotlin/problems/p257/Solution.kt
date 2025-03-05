@file:Suppress("UNUSED")

package com.lvanh.problems.p257

import com.lvanh.utils.TreeNode

/**
 * Problem 257. Binary Tree Paths
 */
class Solution {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        var results = mutableListOf<String>()
        if (root == null) return results
        fun dfs(node: TreeNode, path: String) {
            if (node.left == null && node.right == null) results.add(path)
            else {
                node.left?.let { dfs(it, "$path->${it.`val`}") }
                node.right?.let { dfs(it, "$path->${it.`val`}") }
            }
        }
        dfs(root, "${root.`val`}")
        return results
    }
}
