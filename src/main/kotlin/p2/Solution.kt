@file:Suppress("UNUSED")

package com.lvanh.p2

import com.lvanh.utils.ListNode

/**
 * Problem 2. Add Two Numbers
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var carry = 0
        var result = ListNode(0)
        var current = result
        var list1 = l1
        var list2 = l2
        while (list1 != null && list2 != null || carry != 0) {
            var sum = (list1?.`val` ?: 0) + (list2?.`val` ?: 0) + carry
            current.next = ListNode(sum % 10)
            current = current.next!!
            carry = sum / 10
            list1 = list1?.next
            list2 = list2?.next
        }
        if (list1 != null) current.next = list1
        if (list2 != null) current.next = list2
        return result.next
    }
}
