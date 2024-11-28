package com.example.scb10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scb10.database.Item
import com.example.scb10.database.ItemDao
import com.example.scb10.database.ItemRepository
import com.example.scb10.database.ItemRoomDatabase
import com.example.scb10.databinding.ActivityDataBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataBinding
    lateinit var viewModel: DataViewModel
    lateinit var dao: ItemDao

    var countries = arrayOf("india","usa","uk","russia","china","india","usa","uk","russia","china")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var adapter = CountriesAdapter(countries)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        var  database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()
        val userRepository = ItemRepository(dao)
        val viewModelFactory = DataViewModel.ItemViewModelFactory(userRepository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DataViewModel::class.java)


        viewModel = ViewModelProvider(this)[DataViewModel::class.java]
        viewModel._seconds.observe(this, secsObserver);  //registering/subscribe button/bellicon
        binding.tvCounter.setText(""+viewModel.count)
        binding.btnCount.setOnClickListener {
            viewModel.incrementCount()
            binding.tvCounter.setText(""+viewModel.count)
        }
    }

    var secsObserver : Observer<Int> = object :Observer<Int>{
        override fun onChanged(value: Int) {
            //receiving the update/notification
            binding.tvCounter.setText(value.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        binding.btnTimer.setOnClickListener {
            viewModel.startTimer()
            binding.tvCounter.setText(""+viewModel._seconds)
        }

        binding.btnInsert.setOnClickListener {
            insertDb()
        }

        binding.btnget.setOnClickListener {
            GlobalScope.launch {
                getDb()
            }
        }
    }


    private  fun getDb() {
        var id = binding.etId.text.toString().toInt()
        GlobalScope.launch(Dispatchers.Main) {
            viewModel.getItemById(id).observe(this@DataActivity, Observer { item ->
                // Update UI with user data
                item?.let {
                    binding.tvCounter.setText(item.toString())
                }
            })

        }

    }

    private  fun insertDb() {
        var item = Item(
            binding.etId.text.toString().toInt(),
            binding.etName.text.toString(),
            binding.etprice.text.toString().toDouble(),
            binding.etquantity.text.toString().toInt()
        )
        GlobalScope.launch {
            viewModel.insertItem(item)

        }
    }
}