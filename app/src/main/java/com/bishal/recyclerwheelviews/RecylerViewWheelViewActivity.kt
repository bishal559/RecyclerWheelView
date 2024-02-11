package com.bishal.recyclerwheelviews

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bishal.recyclerwheelviews.data.Member
import com.bishal.recyclerwheelviews.databinding.ActivityRecylerWheelViewBinding
import com.bishal.recyclerwheelviews.model.MemberRecyclerWheelViewAdapter
import java.util.Random


/**
 * Author: Bishal Adhikari
 * @Date: 11/02/2024
 */
class RecylerViewWheelViewActivity : AppCompatActivity() {

    private val tag = "CustomWheelViewTest"
    private lateinit var binding: ActivityRecylerWheelViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recyler_wheel_view)
        setContentView(binding.root)
        val memberList = MutableList(25, init = {
            Member(it, "member $it", 0, "unKnow", "none")
        })
        val memberAdapter = MemberRecyclerWheelViewAdapter(memberList)
        //set selected item callback
        memberAdapter.setOnSelectedMemberCallBack(object :
            MemberRecyclerWheelViewAdapter.OnSelectedMemberCallBack {
            override fun onSelectedMamber(member: Member) {
                binding.tvStringVale.text = "${member.name} age = ${member.age}"
            }
        })
        binding.recyclerWheelView.setRecyclerWheelViewAdapter(memberAdapter)
        binding.updateDataButton.setOnClickListener {
            val newMemberList = MutableList(20, init = {
                Member(
                    it + 1,
                    "new member ${Random().nextInt(100)}  $it",
                    0,
                    "new unKnow",
                    "new none"
                )
            })
            memberAdapter.updateData(newMemberList)
            //update data and set location to first item
            binding.recyclerWheelView.updateDataAndNotify()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }
}