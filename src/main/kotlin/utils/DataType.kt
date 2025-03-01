@file:Suppress("UNUSED")

package com.lvanh.utils

import java.util.LinkedList
import java.util.Queue
import kotlin.collections.toList

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
fun String.toArrayListNode(): Array<ListNode?> = this.to2DIntArray().map { it.toListNode() }.toTypedArray()

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

fun TreeNode?.toIntOrNullArrayStr(): String {
    if (this == null) return "[]"
    val result = mutableListOf<String>()
    val queue: Queue<TreeNode?> = LinkedList<TreeNode?>()
    queue.add(this)
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        if (node?.`val` != null) {
            result.add(node.`val`.toString())
            queue.add(node.left)
            queue.add(node.right)
        } else result.add("null")
    }
    while (result.isNotEmpty() && result.last() == "null") {
        result.removeAt(result.size - 1)
    }
    return result.joinToString(prefix = "[", postfix = "]")
}

fun String.toIntArray(): IntArray = this.removePrefix("[")
    .removeSuffix("]")
    .let { it ->
        if (it.isEmpty()) intArrayOf()
        else it.split(",").map { int -> int.trim().toInt() }.toIntArray()
    }

fun String.to2DIntArray(): Array<IntArray> {
    if (this == "[]") return arrayOf()
    return this.removePrefix("[[")
        .removeSuffix("]]")
        .split("],[").map { row ->
            if (row.isEmpty()) intArrayOf()
            else row.split(",").map { it.toInt() }.toIntArray()
        }.toTypedArray()
}

fun String.to2DIntOrNullArray(): Array<Array<Int?>> = this.removePrefix("[[")
    .removeSuffix("]]")
    .split("],[").map { row ->
        if (row.isEmpty()) arrayOf<Int?>()
        else row.split(",").map {
            if (it == "null") null
            else it.toInt()
        }.toTypedArray()
    }.toTypedArray()

fun String.to2DIntList(): List<List<Int>> = this.removePrefix("[[")
    .removeSuffix("]]")
    .split("],[").map { row ->
        if (row.isEmpty()) listOf<Int>()
        else row.split(",").map {
            it.toInt()
        }
    }

fun String.toIntOrNullArray(): Array<Int?> = this.removePrefix("[")
    .removeSuffix("]")
    .split(",")
    .map { it.trim().toIntOrNull() }
    .toTypedArray()

fun IntArray.toStr(): String = "[${this.joinToString(",")}]"

fun Array<*>.toStr(): String = "[${
    this.joinToString(",") {
        when (it) {
            is IntArray -> it.toStr()
            else -> it.toString()
        }
    }
}]"

fun String.toStr(): String = this.replace("\"", "")
fun String.toStringArray(): Array<String> = this.removePrefix("[")
    .removeSuffix("]")
    .replace("\"", "")
    .split(",")
    .map { it.trim() }
    .toTypedArray()