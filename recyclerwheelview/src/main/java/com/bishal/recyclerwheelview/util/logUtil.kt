package com.bishal.recyclerwheelview.util

import android.util.Log
import com.bishal.recyclerwheelview.BuildConfig


/**
 * Author: Bishal Adhikari
 * @Date: 11/02/2024
 */
private const val TAG = "RecyclerWheelView"


internal fun logDebug(message: String) {
    if (BuildConfig.DEBUG) {
        Log.d(TAG, message)
    }
}

internal fun logInfo(message: String) {
    if (BuildConfig.DEBUG) {
        Log.i(TAG, message)
    }
}

internal fun logWarn(message: String) {
    if (BuildConfig.DEBUG) {
        Log.w(TAG, message)
    }
}

internal fun logError(message: String) {
    if (BuildConfig.DEBUG) {
        Log.e(TAG, message)
    }
}