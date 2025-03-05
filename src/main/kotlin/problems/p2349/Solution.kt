@file:Suppress("UNUSED")

package com.lvanh.problems.p2349

/**
 * Problem 2349. Design a Number Container System
 */
class NumberContainers() {
    var database: HashMap<Int, Int> = HashMap()
    var hashtable: HashMap<Int, ArrayList<Int>> = HashMap()
    fun change(index: Int, number: Int) {
        var listIndex = hashtable[number] ?: arrayListOf()
        database[index]?.let { it ->
            var oldListIndex = hashtable[it] ?: arrayListOf()
            oldListIndex.remove(index)
            hashtable[it] = oldListIndex
        }
        if (index !in listIndex) {
            val i = listIndex.binarySearch(index)
            val insertIndex = if (listIndex.isEmpty()) 0 else if (i < 0) -i - 1 else i
            listIndex.add(insertIndex, index)
        }
        hashtable[number] = listIndex
        database[index] = number
    }

    fun find(number: Int): Int = hashtable[number]?.let { it -> if (it.isEmpty()) -1 else it[0] } ?: -1
}

class Solution {
    fun runTestCase(functions: Array<String>, params: Array<IntArray>): Array<Int?> {
        var obj = NumberContainers()
        var ans = Array<Int?>(params.size) { null }
        for (i in 1..functions.lastIndex) {
            if (functions[i] == "find") ans[i] = obj.find(params[i][0])
            if (functions[i] == "change") obj.change(params[i][0], params[i][1])
        }
        return ans
    }
}

