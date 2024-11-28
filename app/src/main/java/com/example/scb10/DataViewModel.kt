package com.example.scb10

import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {

    var count = 0

    fun incrementCount(){
        count++
    }
}