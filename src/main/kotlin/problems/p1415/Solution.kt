@file:Suppress("UNUSED")

package com.lvanh.problems.p1415

/**
 * Problem 1415. The k-th Lexicographical String of All Happy Strings of Length n
 */

class Solution {
    fun getHappyString(n: Int, k: Int): String {
        var k = k - 1
        if (n == 0 || k >= 3 * (1 shl (n - 1))) return ""
        var ans = StringBuilder(n)
        ans.append("abc"[k / (1 shl (n - 1))])
        k %= 1 shl (n - 1)
        for (i in n - 2 downTo 0) {
            if (k < 1 shl i) ans.append(if (ans[n - i - 2] == 'a') 'b' else 'a')
            else ans.append(if (ans[n - i - 2] == 'c') 'b' else 'c')
            k %= 1 shl i
        }
        return ans.toString()
    }
}