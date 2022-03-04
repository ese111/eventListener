package com.example.eventtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity(), Listener {

    lateinit var customView: Custom

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customView = Custom(this, this)
        val layout = findViewById<ConstraintLayout>(R.id.josh)
        layout.addView(customView)
        Log.d("heungActivity", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("heungActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("heungActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("heungActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("heungActivity", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("heungActivity", "onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("heungActivity", "onDestroy")
    }

    override fun notifycation(str: String) {
        customView.str = str
        customView.invalidate()
    }

//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        val c = findViewById<Custom>(R.id.cus)
//        when(event!!.action){
//            MotionEvent.ACTION_DOWN -> {
//                c.str = "down"
//                Log.d("heungActivity", "down")
//            }
//            MotionEvent.ACTION_MOVE -> {
//                c.str = "move"
//                Log.d("heungActivity", "move")
//            }
//            else -> {
//                c.str = "??"
//                c.performClick()
//                Log.d("heungActivity", "??")
//            }
//        }
//        c.invalidate()
//        return super.onTouchEvent(event)
//    }
}