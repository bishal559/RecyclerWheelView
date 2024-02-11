package com.bishal.recyclerwheelview.util

import android.content.res.Resources


/**
 * Author: Bishal Adhikari
 * @Date: 11/02/2024
 */

internal fun dp2px(dp: Float): Float {
    val density = Resources.getSystem().displayMetrics.density
    return dp * density
}

internal fun sp2px(sp: Float): Float {
    val scaleDensity = Resources.getSystem().displayMetrics.scaledDensity
    return sp * scaleDensity
}