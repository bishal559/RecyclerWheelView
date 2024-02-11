package com.bishal.recyclerwheelview

import android.graphics.drawable.Drawable


/**
 * Author: Bishal Adhikari
 * @Date: 11/02/2024
 */
internal data class RecyclerWheelViewItemInfo(
    val wheelSelectedItemTextColor: Int, val wheelSelectedItemTextSize: Int,
    val wheelSelectedItemBackground: Drawable?, val wheelNormalTextSize: Int,
    val wheelNormalTextColor: Int, val wheelItemHeight: Int,
    val wheelNormalItemBackground: Drawable?
)