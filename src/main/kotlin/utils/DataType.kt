package com.lvanh.utils

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun Array<Int?>.toTree(index: Int): TreeNode? {
    if (index >= this.size) return null
    if (this[index] == null) return null
    var node = TreeNode(`val` = this[index]!!)
    node.left = this.toTree(2 * index + 1)
    node.right = this.toTree(2 * index + 2)
    return node
}

fun String.toTree(): TreeNode? = this.toIntOrNullArray().toTree(0)
fun String.toIntArray(): IntArray  = this.removePrefix("[")
        .removeSuffix("]")
        .split(",")
        .map { it.trim().toInt() }
        .toIntArray()

fun String.toIntOrNullArray(): Array<Int?> = this.removePrefix("[")
        .removeSuffix("]")
        .split(",")
        .map { it.trim().toInt() }
        .toTypedArray()

fun IntArray.toStr(): String = "[${this.joinToString(",")}]"