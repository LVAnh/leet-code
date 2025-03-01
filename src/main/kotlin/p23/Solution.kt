@file:Suppress("UNUSED")

package com.lvanh.p23

import com.lvanh.utils.ListNode
import java.util.PriorityQueue

/**
 * Problem 23. Merge k Sorted Lists
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var root: ListNode? = ListNode(0)
        var curr = root
        var queue = PriorityQueue<ListNode?>(compareBy { it?.`val` })
        for (i in lists.indices) if(lists[i] != null) queue.add(lists[i])
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            curr?.next = node
            curr = curr?.next
            if(node?.next != null) queue.add(node.next)
        }
        return root?.next
    }
}
