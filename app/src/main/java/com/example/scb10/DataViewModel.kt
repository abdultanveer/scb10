package com.example.scb10

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.scb10.database.Item
import com.example.scb10.database.ItemRepository

class DataViewModel(private val repository: ItemRepository) : ViewModel() {
    var TAG = DataViewModel::class.java.simpleName
    lateinit var timer: CountDownTimer
    var _seconds = MutableLiveData<Int>() //seconds observable
    var count = 0

    private val _item = MutableLiveData<Item?>()
    val item: LiveData<Item?> get() = _item

    val allItems: LiveData<List<Item>> = repository.allItems.asLiveData()

    fun incrementCount(){
        count++
    }
//insert into Item (uid,name,itemPrice,quantityInStock) values(3,"grocery",33,333)
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

    suspend fun getItemById(id: Int): LiveData<Item?> {
        return repository.getUserById(id).asLiveData()

//        GlobalScope.launch {
//            _item.value = repository.getUserById(id).asLiveData()   //2
//        }
    }

    suspend fun insertItem(item: Item) {
        repository.insert(item)

    }


//   fun insertDb(item:Item){
//      // var item = Item(11,"fruits",11.11,111)
//       GlobalScope.launch {
//           dao.insert(item)
//       }
//   }
//
//    fun getDb(){
//        GlobalScope.launch (Dispatchers.Main){
//            var item = dao.getItem(11).first()
//           // binding.tvCounter.setText(item.toString())
//        }
//    }

    class ItemViewModelFactory(private val repository: ItemRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DataViewModel::class.java)) {
                return DataViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        }
    }
