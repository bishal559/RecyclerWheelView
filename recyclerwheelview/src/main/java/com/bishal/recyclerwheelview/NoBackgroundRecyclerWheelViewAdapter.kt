package com.bishal.recyclerwheelview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bishal.recyclerwheelview.util.logDebug
import com.bishal.recyclerwheelview.util.logError
import com.bishal.recyclerwheelview.util.logInfo


/**
 * Author: Bishal Adhikari
 * @Date: 11/02/2024
 */
internal class NoBackgroundRecyclerWheelViewAdapter : RecyclerWheelViewAdapter {

    private val stringList: MutableList<String>
    private val recyclerWheelViewItemInfo: RecyclerWheelViewItemInfo

    constructor(
        stringList: MutableList<String>,
        recyclerWheelViewItemInfo: RecyclerWheelViewItemInfo
    ) {
        this.stringList = stringList
        this.recyclerWheelViewItemInfo = recyclerWheelViewItemInfo
        itemHeight = recyclerWheelViewItemInfo.wheelItemHeight
    }

    override fun onBindSelectedViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        logInfo("onBindSelectedViewHolder position = $position")
        val itemViewHolderSelected = holder as ItemViewHolder
        itemViewHolderSelected.contentView.text = stringList[position]
        itemViewHolderSelected.contentView.setTextColor(recyclerWheelViewItemInfo.wheelSelectedItemTextColor)
        itemViewHolderSelected.contentView.textSize =
            recyclerWheelViewItemInfo.wheelSelectedItemTextSize.toFloat()
        if (null != recyclerWheelViewItemInfo.wheelSelectedItemBackground) {
            itemViewHolderSelected.contentView.background =
                recyclerWheelViewItemInfo.wheelSelectedItemBackground
        } else {
            itemViewHolderSelected.contentView.background = null
        }
    }

    override fun onBindNotSelectedViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        logInfo("onBindNotSelectedViewHolder position = $position")
        val itemViewHolderUnSelected = holder as ItemViewHolder
        itemViewHolderUnSelected.contentView.text = stringList[position]
        itemViewHolderUnSelected.contentView.setTextColor(recyclerWheelViewItemInfo.wheelNormalTextColor)
        itemViewHolderUnSelected.contentView.textSize =
            recyclerWheelViewItemInfo.wheelNormalTextSize.toFloat()
        if (null != recyclerWheelViewItemInfo.wheelNormalItemBackground) {
            itemViewHolderUnSelected.contentView.background =
                recyclerWheelViewItemInfo.wheelNormalItemBackground
        } else {
            itemViewHolderUnSelected.contentView.background = null
        }
    }

    override fun getWheelItemCount(): Int {
        logInfo("getWheelItemCount = ${stringList.size}")
        return stringList.size
    }

    override fun onCreateItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        logDebug("onCreateItemViewHolder")
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_nor_recycler_wheel_view, parent, false)
        val layoutParams = rootView.layoutParams
        layoutParams.height = recyclerWheelViewItemInfo.wheelItemHeight
        rootView.layoutParams = layoutParams
        return ItemViewHolder(rootView)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val contentView: TextView = itemView.findViewById(R.id.tv_content)
    }

    override fun onSelectedItemPosition(position: Int) {
        if (position in stringList.indices) {
            NoBackgroundRecyclerWheelView.onSelectedStringCallback?.onSelectedString(stringList[position])
        } else {
            logError("onSelectedItemPosition is wrong!")
        }
    }

}