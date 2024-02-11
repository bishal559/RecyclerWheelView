package com.bishal.recyclerwheelviews.model

import android.graphics.Color
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bishal.recyclerwheelview.RecyclerWheelViewAdapter
import com.bishal.recyclerwheelviews.R
import com.bishal.recyclerwheelviews.data.Member


/**
 * Author: Bishal Adhikari
 * @Date: 11/02/2024
 */
class MemberRecyclerWheelViewAdapter : RecyclerWheelViewAdapter {

    private val memberList = ArrayList<Member>()
    private var onSelectedMemberCallBack: OnSelectedMemberCallBack? = null

    constructor(memberList: MutableList<Member>) {
        this.memberList.addAll(memberList)
    }

    fun setOnSelectedMemberCallBack(onSelectedMemberCallBack: OnSelectedMemberCallBack) {
        this.onSelectedMemberCallBack = onSelectedMemberCallBack
    }

    fun updateData(newMemberList: MutableList<Member>) {
        this.memberList.clear()
        this.memberList.addAll(newMemberList)
    }

    override fun onCreateItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_member_wheel_view, parent, false)
        return MemberViewHolder(view)
    }

    override fun onBindSelectedViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val memberViewHolder = holder as MemberViewHolder
        val member = memberList[position]
        memberViewHolder.nameView.text = member.name
        memberViewHolder.nameView.setTextColor(Color.WHITE)
        memberViewHolder.nameView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        memberViewHolder.nameView.setBackgroundColor(Color.BLUE)
        memberViewHolder.ageView.text = member.age.toString()
        memberViewHolder.ageView.setTextColor(Color.WHITE)
        memberViewHolder.ageView.setBackgroundColor(Color.BLUE)
        memberViewHolder.sexView.text = member.sex
        memberViewHolder.sexView.setTextColor(Color.WHITE)
        memberViewHolder.sexView.setBackgroundColor(Color.BLUE)
    }

    override fun onBindNotSelectedViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val memberViewHolder = holder as MemberViewHolder
        val member = memberList[position]
        memberViewHolder.nameView.text = member.name
        memberViewHolder.nameView.setTextColor(Color.BLACK)
        memberViewHolder.nameView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        memberViewHolder.nameView.setBackgroundColor(Color.TRANSPARENT)
        memberViewHolder.ageView.text = member.age.toString()
        memberViewHolder.ageView.setTextColor(Color.BLACK)
        memberViewHolder.ageView.setBackgroundColor(Color.TRANSPARENT)
        memberViewHolder.sexView.text = member.sex
        memberViewHolder.sexView.setTextColor(Color.BLACK)
        memberViewHolder.sexView.setBackgroundColor(Color.TRANSPARENT)
    }

    override fun getWheelItemCount(): Int {
        return memberList.size
    }

    /**
     * @param position the location selected in your data list
     */
    override fun onSelectedItemPosition(position: Int) {
        if (position in memberList.indices) {
            onSelectedMemberCallBack?.onSelectedMamber(memberList[position])
        } else {
            Log.e("recyclerwheelview", "onSelectedItemPosition error")
        }
    }

    class MemberViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.findViewById(R.id.member_name)
        val ageView: TextView = view.findViewById(R.id.member_age)
        val sexView: TextView = view.findViewById(R.id.member_sex)
    }

    interface OnSelectedMemberCallBack {
        fun onSelectedMamber(member: Member)
    }
}