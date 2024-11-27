package com.example.scb10

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var logButton:Button
    var TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logButton = findViewById(R.id.btnLog)

        logButton.setOnClickListener {
            Log.i(TAG,"button was clicked")
        }

    }

    fun handleClick(view: View) {
        var view:ConstraintLayout = findViewById(R.id.constraintlayout)
       var snackbar =  Snackbar.make(view,"1 archived",Snackbar.LENGTH_LONG)
        snackbar.setAction("undo",{})
        snackbar.show()
    }
}