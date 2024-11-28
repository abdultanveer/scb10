package com.example.scb10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.scb10.databinding.ActivityDataBinding
import com.example.scb10.databinding.ActivityMainBinding

class DataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataBinding
    lateinit var viewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
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
    }
}