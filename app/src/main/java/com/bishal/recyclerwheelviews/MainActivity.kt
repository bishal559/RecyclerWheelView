package com.bishal.recyclerwheelviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bishal.recyclerwheelview.NoBackgroundRecyclerWheelView
import com.bishal.recyclerwheelviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var stringList: MutableList<String>


    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        initialization()
    }

    private fun initialization(){
        stringList = MutableList(20, init = {
            "value $it"
        })
        with(binding){
            btnRecyclerView.setOnClickListener {
                Intent(this@MainActivity,RecylerViewWheelViewActivity::class.java).apply {
                    startActivity(this)
                }
            }
            btnNoBackgroundRecyclerView.setOnClickListener {
                Intent(this@MainActivity,NoBackgroundRecylerWheelViewActivity::class.java).apply {
                    startActivity(this)
                }
            }
        }

    }
}