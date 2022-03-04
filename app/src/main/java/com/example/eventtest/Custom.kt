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

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d("heungCustom" , "onAttachedToWindow")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.d("heungCustom" , "onMeasure")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Log.d("heungCustom" , "onLayout")
    }

    override fun layout(l: Int, t: Int, r: Int, b: Int) {
        super.layout(l, t, r, b)
        Log.d("heungCustom" , "layout")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.d("heungCustom" , "onDetachedFromWindow")
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        Log.d("heungCustom" , "draw")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = Color.BLACK
        paint.textSize = 100F
        canvas!!.drawText(str, 200F, 200F, paint)
        Log.d("heungCustom" , "onDraw")
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event!!.action){
            MotionEvent.ACTION_DOWN -> {
//                pushMsg()
                notice("ACTION_DOWN")
                Log.d("heungCustom", "down")
            }
            MotionEvent.ACTION_MOVE -> {
//               moveMsg()
                notice("ACTION_MOVE")
                Log.d("heungCustom", "down")
            }
            else -> {
//                elseMsg()
                performClick()
                notice("ELSE")
                Log.d("heungCustom", "down")
            }
        }
        Log.d("heungCustom", "onTouch")
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