@file:Suppress("UNUSED")

package com.lvanh.problems.p1458

/**
 * Problem 1458. Max Dot Product of Two Subsequences
 */
class Solution {
    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
        val dp = Array(nums1.size) { IntArray(nums2.size) { 0 } }
        dp[0][0] = nums1[0] * nums2[0]
        for (i in 1..nums1.lastIndex) {
            dp[i][0] = maxOf(nums1[i] * nums2[0], dp[i - 1][0])
        }
        for (i in 1..nums2.lastIndex) {
            dp[0][i] = maxOf(nums1[0] * nums2[i], dp[0][i - 1])
        }
        for (i in 1..nums1.lastIndex) {
            for (j in 1..nums2.lastIndex) {
                dp[i][j] =
                    maxOf(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] + nums1[i] * nums2[j], nums1[i] * nums2[j])
            }
        }
        return dp[nums1.lastIndex][nums2.lastIndex]
    }
}