@file:Suppress("UNUSED")

package com.lvanh.p88

/**
 * Problem 88. Merge Sorted Array
 */
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): IntArray {
        var i = m - 1
        var j = n - 1
        var k = m + n - 1
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) nums1[k--] = nums1[i--]
            else nums1[k--] = nums2[j--]
        }
        while (j >= 0 )nums1[k--] = nums2[j--]
        return nums1
    }
}
