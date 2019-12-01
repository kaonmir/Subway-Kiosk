package com.example.fuckingviewpagedamn

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.os.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.net.InetSocketAddress
import java.net.Socket
import java.net.SocketAddress


const val CONTACT_REQUEST_MENU = 1

class MainActivity : AppCompatActivity() {

    private val menuList = mutableListOf<Menu>()
    private val textViewList = mutableListOf<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentOne(), "One")
        adapter.addFragment(FragmentTwo(), "Two")
        viewPager.adapter = adapter

        btn_clearAll.setOnClickListener {
            menuList.clear()
            textViewList.clear()
            OrderLayout.removeAllViews()
        }
        btn_payment.setOnClickListener {
            val text = menuList.joinToString(",") { it.toJson() }
            println("Your crazy food is $text")

            val params = ContentValues()
            params.put("menus", text)
            Thread(Runnable {
                run {
                    val responseStr = RequestHttpURLConnection().request(
                        MyUrl().getBaseUrl() + "/consumer",
                        params
                    )
                    println("Response is $responseStr")
                }
            }).start()
            menuList.clear()
            textViewList.clear()
            OrderLayout.removeAllViews()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == CONTACT_REQUEST_MENU && resultCode == Activity.RESULT_OK) {
            if(data!!.hasExtra("menu")) {
                val menu: Menu? = data.getParcelableExtra("menu")
                if (menu != null) {
                    println("Cheeeeeese " + menu.cheese)

                    val textView = TextView(this)
                    textView.textSize = 15F
                    textView.text = "${menu.name}: ${menu.price} Won"
                    textViewList.add(textView)
                    menuList.add(menu)

                    OrderLayout.addView(textView)
                } else error("menu is Error!!!")
            } else error("Why there is no menu object damn!")
        }
    }
    fun setImage(imgView: ImageView, url: MyUrl) {
        Thread(Runnable {
            run {
                runOnUiThread {
                    GlideApp.with(this).load(url.getImageurl()).into(imgView)
                }
            }
        }).start()
    }
    class MyViewPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager) {
        private val fragmentList : MutableList<Fragment> = ArrayList()
        private val titleList : MutableList<String> = ArrayList()


        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }
        override fun getCount(): Int {
            return fragmentList.size
        }
        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }

    }
}
class MyUrl() {
    private val baseurl = "http://18.223.126.221"
    var imageName: String = ""
    var folder: String? = ""
    constructor(imageName: String, folder: String?) : this() {
        this.imageName = imageName
        this.folder = folder
    }
    constructor(imageName: String) : this() {
        this.imageName = imageName
        this.folder = null
    }
    fun getImageurl(): String {
        if(folder != null) return "$baseurl/$folder/$imageName"
        else return "$baseurl/$imageName"
    }
    fun getBaseUrl(): String {return baseurl }
}