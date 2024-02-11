package com.bishal.recyclerwheelviews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bishal.recyclerwheelview.NoBackgroundRecyclerWheelView
import com.bishal.recyclerwheelviews.databinding.ActivityNoBackgroundRecyclerWheelViewBinding

class NoBackgroundRecylerWheelViewActivity : AppCompatActivity() {
    private lateinit var stringList: MutableList<String>


    private lateinit var binding : ActivityNoBackgroundRecyclerWheelViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_no_background_recycler_wheel_view)
        setContentView(binding.root)
        initialization()
    }

    private fun initialization(){
        stringList = MutableList(20, init = {
            "value $it"
        })
        with(binding){
            noBgRv.setOnSelectedStringCallback(object :
                NoBackgroundRecyclerWheelView.OnSelectedStringCallback {
                override fun onSelectedString(selectedString: String) {

                }
            })
            noBgRv.setStringItemList(stringList)
        }

    }
}