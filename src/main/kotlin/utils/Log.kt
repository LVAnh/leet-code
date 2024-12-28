package com.lvanh.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Log {
    private val logger: Logger = LoggerFactory.getLogger(Log::class.java)
    fun d(message: String) = logger.debug(message)
}

fun logd(message: String) = Log.d(message)