@file:Suppress("UNUSED")

package com.lvanh.p2570

import java.util.PriorityQueue

/**
 * Problem 2570. Merge Two 2D Arrays by Summing Values
 */
class Solution {
    fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
        var hashtable = PriorityQueue<IntArray>(compareBy { it[0] })
        var ans = ArrayList<IntArray>()
        for (i in nums1.indices) hashtable.add(nums1[i])
        for (i in nums2.indices) hashtable.add(nums2[i])
        while (hashtable.isNotEmpty()) {
            var curr = hashtable.poll()
            if (hashtable.peek()!=null&&hashtable.peek()[0] == curr[0]) curr[1] += hashtable.poll()[1]
            ans.add(curr)
        }
        return ans.toTypedArray()
    }
}
