@file:Suppress("UNUSED")

package com.lvanh.p1352

/**
 * Problem 1352. Product of the Last K Numbers
 */

class ProductOfNumbers() {
    var prefixSum: ArrayList<Int> = arrayListOf<Int>()
    var lastZeroIndex: Int = -1
    fun add(num: Int) {
        if (num == 0) {
            prefixSum.add(0)
            lastZeroIndex = prefixSum.lastIndex
        } else {
            var last = prefixSum.lastOrNull() ?: 0
            if (last == 0) prefixSum.add(num)
            else prefixSum.add(num * last)
        }
    }

    fun getProduct(k: Int): Int {
        if (lastZeroIndex >= prefixSum.size - k) return 0
        var product = prefixSum.lastIndex - k
        if (product == lastZeroIndex) return prefixSum.last()
        return prefixSum.last() / prefixSum[product]
    }
}

class Solution {
    fun runTestCase(functions: Array<String>, params: Array<IntArray>): Array<Int?> {
        var obj = ProductOfNumbers()
        var ans = Array<Int?>(params.size) { null }

        for (i in 1..functions.lastIndex) {
            if (functions[i] == "add") obj.add(params[i][0])
            if (functions[i] == "getProduct") ans[i] = obj.getProduct(params[i][0])
        }
        return ans
    }
}