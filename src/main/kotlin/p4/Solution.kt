@file:Suppress("UNUSED")

package com.lvanh.p4

/**
 * Problem 4. Median of Two Sorted Arrays
 */

class Solution {

    /**
     * Approach 1: Merge Sort
     */
    fun findMedianSortedArrays1(nums1: IntArray, nums2: IntArray): Double {
        var n = nums1.size + nums2.size
        var n1 = nums1.size
        var n2 = nums2.size
        var i1 = 0
        var i2 = 0
        var value = -1
        var lastValue = -1
        while (i1 + i2 <= n / 2) {
            lastValue = value
            value = if (i1 < n1 && i2 < n2) if (nums1[i1] < nums2[i2]) nums1[i1++] else nums2[i2++]
            else if (i1 < n1) nums1[i1++] else nums2[i2++]
        }
        return if (n % 2 != 0) value * 1.0 else (value + lastValue) * 0.5
    }
}
