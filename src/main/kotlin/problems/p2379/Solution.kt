@file:Suppress("UNUSED")

package com.lvanh.problems.p2379

/**
 * Problem 2379. Minimum Recolors to Get K Consecutive Black Blocks
 */
class Solution {
    fun minimumRecolors(blocks: String, k: Int): Int {
        var white = 0
        var ans = Int.MAX_VALUE
        for (i in 0 until blocks.length) {
            if (blocks[i] == 'W') white++
            if (i >= k && blocks[i - k] == 'W') white--
            if (i >= k - 1) ans = minOf(ans, white)
        }
        return ans
    }
}
