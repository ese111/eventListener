package com.example.eventtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity(), Listener {
    lateinit var customView: Custom

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customView = Custom(this, this)
        val layout = findViewById<ConstraintLayout>(R.id.josh)
        layout.addView(customView)
    }

    override fun notifycation(str: String) {
        customView.str = str
        customView.invalidate()
    }

}