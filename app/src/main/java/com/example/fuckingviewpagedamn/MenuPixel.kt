package com.example.fuckingviewpagedamn

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.menupixel.view.*

class MenuPixel : LinearLayout, View.OnClickListener {

    private val menu: Menu = Menu()

    constructor(imageId: String, text: String, price: Int, context: Context, attrs: AttributeSet, defStyle: Int): super(context,attrs)
    {
        initView(imageId, text, price, context)
    }
    constructor(imageId: String, text: String, price: Int, context: Context, attrs: AttributeSet): this(imageId, text, price, context, attrs, 0)
    constructor(imageId: String, text: String, price: Int, context: Context): super(context) {initView(imageId, text, price, context)}
    private fun initView(imageId: String, text: String, price: Int, context: Context) {
        LayoutInflater.from(context).inflate(R.layout.menupixel, this, true)
        (context as MainActivity).setImage(imageView, MyUrl(imageId, "menu"))


        textView.text = text
        menu.name = text
        menu.price = price
        imageView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Toast.makeText(context, "You order ${menu.name} Sandwich\nIt's ${menu.price} won", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, OptionSelectActivity::class.java)

        intent.putExtra("menu", menu)
        (context as Activity).startActivityForResult(intent, CONTACT_REQUEST_MENU)

    }

}