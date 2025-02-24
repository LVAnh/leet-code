@file:Suppress("UNUSED")

package com.lvanh.p889

import com.lvanh.utils.TreeNode

/**
 * Problem 889. Construct Binary Tree from Preorder and Postorder Traversal
 */

class Solution {
    fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
        var preIndex = 0
        var postIndex = 0
        fun construct(preorder: IntArray, postorder: IntArray): TreeNode?{
            val node = TreeNode(preorder[preIndex++])
            if (postorder[postIndex] != node.`val`) node.left = construct(preorder, postorder)
            if (postorder[postIndex] != node.`val`) node.right = construct(preorder, postorder)
            postIndex++
            return node
        }
        return construct(preorder, postorder)
    }
}
