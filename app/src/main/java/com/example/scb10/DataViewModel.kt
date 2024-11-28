package com.example.scb10

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scb10.database.Item

class DataViewModel : ViewModel() {
    var TAG = DataViewModel::class.java.simpleName
    lateinit var timer: CountDownTimer
    var _seconds = MutableLiveData<Int>() //seconds observable
    var count = 0

    fun incrementCount(){
        count++
    }

    fun startTimer(){
        timer = object :CountDownTimer(10_000,1_000){
            override fun onTick(timeRemaining: Long) {
                _seconds.value = timeRemaining.toInt()
                Log.i(TAG,"time remainninng --"+_seconds)

            }

            override fun onFinish() {
                Log.i(TAG,"timer finnished")
            }

        }.start()

        }

   fun insertDb(item:Item){}
}