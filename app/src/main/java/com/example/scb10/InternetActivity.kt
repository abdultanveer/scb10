package com.example.scb10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import com.example.scb10.databinding.ActivityInternetBinding
import com.example.scb10.databinding.ActivityMainBinding
import com.example.scb10.networking.MarsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InternetActivity : AppCompatActivity() {
    lateinit var binding: ActivityInternetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternetBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnJson.setOnClickListener { getMarsPhotos() }
    }

    private fun getMarsPhotos() {
       GlobalScope.launch(Dispatchers.Main) {
           val url = MarsApi.retrofitService.getPhotos().get(0).imgSrc
          // binding.tvJSon.setText(listResult.toString())
           binding.imageView2.load(url)

       }
    }
}