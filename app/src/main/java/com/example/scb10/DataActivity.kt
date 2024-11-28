package com.example.scb10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.scb10.databinding.ActivityDataBinding
import com.example.scb10.databinding.ActivityMainBinding

class DataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataBinding
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCount.setOnClickListener {
            count++
            binding.tvCounter.setText(""+count)
        }
    }
}