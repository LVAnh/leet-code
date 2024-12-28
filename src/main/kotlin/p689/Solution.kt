@file:Suppress("UNUSED")

package com.lvanh.p689

/**
 * Problem 689. Maximum Sum of 3 Non-Overlapping Subarrays
 */
class Solution {
    fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
        var sums = IntArray(nums.size - k + 1)
        var windowSum = 0
        for (i in 0 until k) windowSum += nums[i]
        sums[0] = windowSum
        for (i in 1..nums.size - k) {
            windowSum = windowSum + nums[i+k-1] - nums[i-1]
            sums[i] = windowSum
        }
        var n3 = nums.size - k + 1
        var dp3 = IntArray(n3)
        for (i in 0 until n3) {
            var max = i
            for (j in i until n3) if (sums[max] < sums[j]) max = j
            dp3[i] = max
        }
        var n2 = nums.size - 2 * k + 1
        var dp2 = IntArray(n2)
        for (i in 0 until n2) {
            var max = i
            var sumMax = sums[max] + sums[dp3[max + k]]
            for (j in i until n2) {
                var sumJ = sums[j] + sums[dp3[j + k]]
                if (sumMax < sumJ) {
                    max = j
                    sumMax = sumJ
                }
            }
            dp2[i] = max
        }
        var n1 = nums.size - 3 * k + 1
        var max = 0
        var sumMax = sums[0] + sums[dp2[k]] + sums[dp3[dp2[k] + k]]
        for (j in 0 until n1) {
            var sumJ = sums[j] + sums[dp2[j + k]] + sums[dp3[dp2[j + k] + k]]
            if (sumMax < sumJ) {
                max = j
                sumMax = sumJ
            }
        }
        return intArrayOf(max, dp2[max + k], dp3[dp2[max + k] + k])
    }
}
