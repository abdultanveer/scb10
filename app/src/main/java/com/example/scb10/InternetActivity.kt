package com.example.scb10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.scb10.databinding.ActivityInternetBinding
import com.example.scb10.databinding.ActivityMainBinding
import com.example.scb10.networking.MarsApi
import com.example.scb10.networking.MarsPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InternetActivity : AppCompatActivity() {
    lateinit var binding: ActivityInternetBinding
    lateinit var adapter:WordListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternetBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnJson.setOnClickListener { getMarsPhotos() }
    }

    override fun onStart() {
        super.onStart()
        getMarsPhotos()
        adapter = WordListAdapter()
        binding.recyclerView.layoutManager =  LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun getMarsPhotos() {
       GlobalScope.launch(Dispatchers.Main) {
           val listMarsphots = MarsApi.retrofitService.getPhotos()
           adapter.submitList(listMarsphots)

       }
    }
}