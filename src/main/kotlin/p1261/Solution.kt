@file:Suppress("UNUSED")

package com.lvanh.p1261

import com.lvanh.utils.TreeNode
import com.lvanh.utils.toTree

/**
 * Problem 1261. Find Elements in a Contaminated Binary Tree
 */
class FindElements(root: TreeNode?) {
    val values: HashSet<Int> = hashSetOf<Int>()
    init {
        recoverTree(root, 0)
    }
    fun  recoverTree(node: TreeNode?, value: Int) {
        if(node == null) return
        node.`val` = value
        values.add(value)
        recoverTree(node.left, 2 * value + 1)
        recoverTree(node.right, 2 * value + 2)
    }
    fun find(target: Int): Boolean = values.contains(target)
}

class Solution {
    fun runTestCase(functions: Array<String>, params: Array<Array<Int?>>): Array<Boolean?> {
        var root = params[0].toTree(0)
        var obj = FindElements(root)
        var ans = Array<Boolean?>(params.size) { null }
        for (i in 1..functions.lastIndex) {
            ans[i] = obj.find(params[i][0]!!)
        }
        return ans
    }
}