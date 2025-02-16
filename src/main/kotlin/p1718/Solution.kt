@file:Suppress("UNUSED")

package com.lvanh.p1718

/**
 * Problem 1718. Construct the Lexicographically Largest Valid Sequence
 */

class Solution {
    fun constructDistancedSequence(n: Int): IntArray {
        fun backtracking(array: IntArray, stack: ArrayList<Int>): IntArray? {
            var currentIndex = -1
            for (i in array.indices) {
                if (array[i] == 0) {
                    currentIndex = i
                    break
                }
            }
            if (currentIndex == -1) return array

            var i = 0
            while (i < stack.size) {
                var current = stack[i]
                var new = array.clone()
                var stackCopy = ArrayList(stack)
                if (current == 1) {
                    new[currentIndex] = current
                    stackCopy.removeAt(i)
                    var result = backtracking(new, stackCopy)
                    if (result != null) return result
                } else {
                    if (currentIndex + current > array.lastIndex) return null
                    if (array[currentIndex + current] == 0) {
                        new[currentIndex] = current
                        new[currentIndex + current] = current
                        stackCopy.removeAt(i)
                        var result = backtracking(new, stackCopy)
                        if (result != null) return result
                    }
                }
                i++
            }
            return null
        }

        var ans = IntArray(2 * n - 1)
        var stack = ArrayList<Int>()
        for (i in n downTo 1) stack.add(i)
        ans = backtracking(ans, stack) ?: IntArray(2 * n - 1)
        return ans
    }
}