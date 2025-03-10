package com.lvanh.utils

import java.io.File
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KParameter.Kind
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.jvm.javaMethod
import kotlin.reflect.typeOf
import kotlin.system.measureTimeMillis

fun <R> KFunction<R>.run(receiver: Any? = null) {
    val testCase = this.getTestCase()
    var parameters = this.parameters
    val args = testCase.trimMargin().split("\n")
    var realParamsSize = parameters.size
    var instance: Any? = null
    var receiverRequired = false

    if (parameters.firstOrNull()?.kind == Kind.INSTANCE) {
        var clazz = parameters.firstOrNull()?.type?.classifier as? KClass<*>
        instance = clazz?.createInstance()
        realParamsSize = parameters.size - 1
    }
    if (parameters.firstOrNull()?.kind == Kind.EXTENSION_RECEIVER) {
        if (receiver == null) throw Exception("Receiver does not null")
        receiverRequired = true
        realParamsSize = parameters.size - 1
    }

    for (i in 0 until args.size / realParamsSize) {
        var params = arrayListOf<Any?>()
        if (instance != null) params.add(instance)
        if (receiverRequired) params.add(receiver)
        val start = parameters.size - realParamsSize
        for (j in start until parameters.size) {
            var argStr = args[i * realParamsSize + j - start]
            val arg = when (parameters[j].type.classifier) {
                String::class -> argStr.toStr()
                Array<String>::class -> argStr.toStringArray()
                Int::class -> argStr.toInt()
                Long::class -> argStr.toLong()
                Double::class -> argStr.toDouble()
                IntArray::class -> argStr.toIntArray()
                Array<IntArray>::class -> argStr.to2DIntArray()
                Array<Array<Int?>>::class -> argStr.to2DIntOrNullArray()
                TreeNode::class -> argStr.toTree()
                ListNode::class -> argStr.toListNode()
                Array<ListNode?>::class -> argStr.toArrayListNode()
                else -> when {
                    parameters[j].type.isSubtypeOf(typeOf<List<List<Int>>>()) -> argStr.to2DIntList()
                    else -> throw Exception("Type does not define of ${parameters[j].type}")
                }

            }
            params.add(arg)
        }
        val runtime = Runtime.getRuntime()

        var memoryUsed = runtime.freeMemory()
        var output: R
        val executionTime = measureTimeMillis { output = this.call(*params.toArray()) }
        memoryUsed -= runtime.freeMemory()
        val outStr = when (output) {
            is IntArray -> output.toStr()
            is Array<*> -> output.toStr()
            is ListNode -> output.toStr()
            is TreeNode? -> output.toIntOrNullArrayStr()
            else -> output.toString()
        }
        logd("Runtime: $executionTime ms - Memory: ${memoryUsed / 1024} Bytes")
        logd(outStr)
    }
}

fun <R> KFunction<R>.getTestCase(): String {
    val practice = this.javaMethod?.declaringClass?.packageName?.split(".")?.last()
    val userDir = System.getProperty("user.dir")
    val filePath = "$userDir/src/main/kotlin/problems/$practice/testCase.txt"
    return File(filePath).readText()
}

