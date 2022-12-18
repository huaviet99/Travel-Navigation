package com.vteam.travel_navigation.utils

import android.util.Log

class LogUtil {
    companion object {
        private const val LOG_TAG = "travel_navigation"
        private const val IS_TRACE_LOG_ON = true
        private const val IS_ERROR_LOG_ON = true

        fun traceIn(className: String?, message: String) {
            if (IS_TRACE_LOG_ON) {
                className?.let {
                    Log.d(LOG_TAG, "TRACE_IN>>> [$it] $message")
                }
            }
        }

        fun traceOut(className: String?, message: String) {
            if (IS_TRACE_LOG_ON) {
                className?.let {
                    Log.d(LOG_TAG, "TRACE_OUT>> [$it] $message")
                }
            }
        }

        fun error(className: String?, message: String) {
            if (IS_ERROR_LOG_ON) {
                className?.let {
                    Log.e(LOG_TAG, "ERROR>> [$it] $message")
                }
            }
        }

        fun error(className: String?, message: String, throwable: Throwable) {
            if (IS_ERROR_LOG_ON) {
                className?.let {
                    Log.e(LOG_TAG, "ERROR>> [$it] $message", throwable)
                }
            }
        }
    }
}
