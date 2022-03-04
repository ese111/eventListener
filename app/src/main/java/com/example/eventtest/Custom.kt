package com.example.eventtest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.MotionEvent
import android.view.View

class Custom : View {
    lateinit var listener: Listener
    constructor(_listener: Listener, context: Context?) : super(context) {
        listener = _listener
    }

    var str = "yet"


    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        Log.d("myCustom", "draw")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = Color.BLACK
        paint.textSize = 100F
        canvas!!.drawText(str, 200F, 200F, paint)
        Log.d("myCustom", "onDraw")
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d("myCustom", "onTouch")
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                notice("ACTION_DOWN")
                Log.d("myCustom", "down")
            }
            MotionEvent.ACTION_MOVE -> {
                notice("ACTION_MOVE")
                Log.d("myCustom", "move")
            }
            else -> {
                performClick()
                notice("ELSE")
                Log.d("myCustom", "else")
            }
        }
        invalidate()
        return true
    }

    private fun pushMsg() {
        str = "눌렀다."
    }

    private fun moveMsg() {
        str = "움직인다"
    }

    private fun elseMsg() {
        str = "뭐하냐?"
    }

    fun notice(tt: String) {
        listener.notifycation(tt)
    }

}