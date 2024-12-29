@file:Suppress("UNUSED")

package com.lvanh.utils

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun IntArray.toListNode(): ListNode? {
    if (this.isEmpty()) return null
    var root = ListNode(this.first())
    var current: ListNode? = root
    for (i in 1 until size) {
        current?.next = ListNode(this[i])
        current = current?.next
    }
    return root
}

fun ListNode?.toIntArray(): IntArray {
    if (this == null) return intArrayOf()
    var result = arrayListOf<Int>()
    var curr = this
    while (curr != null) {
        result.add(curr.`val`)
        curr = curr.next
    }
    return result.toIntArray()
}

fun String.toListNode(): ListNode? = this.toIntArray().toListNode()

fun ListNode.toStr(): String = this.toIntArray().toStr()

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

fun String.toIntArray(): IntArray = this.removePrefix("[")
    .removeSuffix("]")
    .split(",")
    .map { it.trim().toInt() }
    .toIntArray()

fun String.to2DIntArray(): Array<IntArray> = this.removePrefix("[[")
    .removeSuffix("]]")
    .split("],[").map { row ->
        row.split(",").map { it.toInt() }.toIntArray()
    }.toTypedArray()

fun String.toIntOrNullArray(): Array<Int?> = this.removePrefix("[")
    .removeSuffix("]")
    .split(",")
    .map { it.trim().toIntOrNull() }
    .toTypedArray()

fun IntArray.toStr(): String = "[${this.joinToString(",")}]"

fun String.toStr(): String = this.replace("\"", "")