package com.example.scb10

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.scb10.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

   // lateinit var logButton:Button
   private lateinit var binding: ActivityMainBinding
var count = 0
    var TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
       // setContentView(R.layout.activity_main) //inflating xml == parsing and allocating mem
      //  logButton = findViewById(R.id.btnLog)

        binding.btnLog.setOnClickListener {
            Log.i(TAG,"button was clicked")
            var name = binding.etName.text.toString()
            binding.tvMain.setText(name)
        }

        binding.btnincrease.setOnClickListener {
            count++
            binding.tvMain.setText(""+count)
        }

        binding.btnDial.setOnClickListener {
            var myIntention :Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9880979732"))
            startActivity(myIntention)

        }

    }

    fun handleClick(view: View) {
        var view:ConstraintLayout = findViewById(R.id.constraintlayout)
       var snackbar =  Snackbar.make(view,"1 archived",Snackbar.LENGTH_LONG)
        snackbar.setAction("undo",{})
        snackbar.show()
    }
}