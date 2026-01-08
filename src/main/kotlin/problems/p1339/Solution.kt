@file:Suppress("UNUSED")

package com.lvanh.problems.p1339

import com.lvanh.utils.TreeNode

/**
 * Problem 1339. Maximum Product of Splitted Binary Tree
 */

class Solution {
    fun maxProduct(root: TreeNode?): Int {
        fun dfsSum(root: TreeNode?): Int {
            if (root == null) return 0
            return dfsSum(root.left) + dfsSum(root.right) + root.`val`
        }

        val sum = dfsSum(root)
        var max = Long.MIN_VALUE
        fun dfsProduct(root: TreeNode?): Int {
            if (root == null) return 0
            val sumLeft = dfsProduct(root.left)
            val sumRight = dfsProduct(root.right)
            max = maxOf(max, 1L * sumLeft * (sum - sumLeft), 1L * sumRight * (sum - sumRight))
            return sumLeft + sumRight + root.`val`
        }
        dfsProduct(root)
        return (max % 1_000_000_007).toInt()
    }
}