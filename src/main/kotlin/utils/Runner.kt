package com.lvanh.utils

import java.io.File
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KParameter.Kind
import kotlin.reflect.full.createInstance
import kotlin.reflect.jvm.javaMethod

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
                IntArray::class -> argStr.toIntArray()
                Array<IntArray>::class -> argStr.to2DIntArray()
                TreeNode::class -> argStr.toTree()
                ListNode::class -> argStr.toListNode()
                else -> throw Exception("Type does not define of ${parameters[j].type}")
            }
            params.add(arg)
        }
        val output = this.call(*params.toArray())
        val outStr = when (output) {
            is IntArray -> output.toStr()
            is Array<*> -> output.toStr()
            is ListNode -> output.toStr()
            else -> output.toString()
        }
        logd(outStr)
    }
}

fun <R> KFunction<R>.getTestCase(): String {
    val practice = this.javaMethod?.declaringClass?.packageName?.split(".")?.last()
    val userDir = System.getProperty("user.dir")
    val filePath = "$userDir/src/main/kotlin/$practice/testCase.txt"
    return File(filePath).readText()
}

