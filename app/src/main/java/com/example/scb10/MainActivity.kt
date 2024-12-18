package com.example.scb10

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
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
    var TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "egg -- oncreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
       // setContentView(R.layout.activity_main) //inflating xml == parsing and allocating mem
      //  logButton = findViewById(R.id.btnLog)

        binding.btnLog.setOnClickListener {
            Log.i(TAG,"button was clicked")
            var name = binding.etName.text.toString()
            binding.tvMain.setText(name)
           var result = addNnos(10,20)
           // throw NullPointerException("debug app demo")
        }

        binding.btnincrease.setOnClickListener {
            count++
            binding.tvMain.setText(""+count)
        }

        binding.btnDial.setOnClickListener {
            var myIntention :Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9880979732"))
            startActivity(myIntention)

        }

        binding.btnHome.setOnClickListener {
            var homeIntent = Intent(this,HomeActivity::class.java)
            homeIntent.putExtra("scb10","android-16 participannts")
            startActivity(homeIntent)
        }

        binding.btnAlarm.setOnClickListener { createAlarm("b10",11,35) }

    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "hatched -- onstart--get location- data query")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "wakeup -- resume-- restore app state")

    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "sleep -- pause--store to app state")
    }

    override fun onStop() {
        super.onStop()
        Log.w(TAG, "hibernnate -- stop--save the state/resources")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "death -- destroyed--release the resources")
    }


    private fun addNnos(i: Int, i1: Int): Int {
       var c = 20+30
        repeat(5){
            c++
            c += 10
        }

        return  i + i1
    }

    fun handleClick(view: View) {
        var view:ConstraintLayout = findViewById(R.id.constraintlayout)
       var snackbar =  Snackbar.make(view,"1 archived",Snackbar.LENGTH_LONG)
        snackbar.setAction("undo",{})
        snackbar.show()
    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
       // if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        //}
    }

}