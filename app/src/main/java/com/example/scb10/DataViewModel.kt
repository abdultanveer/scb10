package com.example.scb10

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    var TAG = DataViewModel::class.java.simpleName
    lateinit var timer: CountDownTimer
    var _seconds:Int =  0
    var count = 0

    fun incrementCount(){
        count++
    }

    fun startTimer(){
        timer = object :CountDownTimer(10_000,1_000){
            override fun onTick(timeRemaining: Long) {
                _seconds = timeRemaining.toInt()
                Log.i(TAG,"time remainninng --"+_seconds)

            }

            override fun onFinish() {
                Log.i(TAG,"timer finnished")
            }

        }.start()

        }
}