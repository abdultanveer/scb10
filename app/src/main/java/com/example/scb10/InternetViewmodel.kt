package com.example.scb10

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scb10.networking.MarsApi
import com.example.scb10.networking.MarsPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.lifecycle.asLiveData


class InternetViewmodel:ViewModel() {
     /*lateinit var  _listMarsPhotos:MutableLiveData<MarsPhoto>()

   val listMarsphots: LiveData<MarsPhoto>
            get() = _listMarsPhotos*/


    private var _item = MutableLiveData<MarsPhoto?>()
    val item: LiveData<MarsPhoto?> get() = _item


         fun getMarsPhotos() {
        GlobalScope.launch(Dispatchers.Main) {
           // _item = MarsApi.retrofitService.getPhotos()

        }
    }
}