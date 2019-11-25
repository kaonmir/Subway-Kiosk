package com.example.fuckingviewpagedamn

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.menupixel.view.*

class MenuPixel : LinearLayout, View.OnClickListener {
    private var price: Int = 0

    constructor(imageId: Int, text: String, price: Int, context: Context, attrs: AttributeSet, defStyle: Int): super(context,attrs)
    {
        initView(imageId, text, price, context)
    }
    constructor(imageId: Int, text: String, price: Int, context: Context, attrs: AttributeSet): this(imageId, text, price, context, attrs, 0)
    constructor(imageId: Int, text: String, price: Int, context: Context): super(context) {initView(imageId, text, price, context)}
    private fun initView(imageId: Int, text: String, price: Int, context: Context) {
        LayoutInflater.from(context).inflate(R.layout.menupixel, this, true)
        imageView.setImageResource(imageId)
        textView.text = text
        this.price = price

        imageView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Toast.makeText(context, "You order ${textView.text} Sandwich\nIt's $price won", Toast.LENGTH_SHORT).show()
    }

}