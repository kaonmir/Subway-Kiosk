package com.example.fuckingviewpagedamn

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_option_select.*

class OptionSelectActivity : AppCompatActivity() {

    var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_select)

        menu = intent.getParcelableExtra("menu")
        val breadLengthImgList = listOf<ImageView>(imgView_bread_short, imgView_bread_long)
        val breadTypeImgList
                = listOf<List<ImageView>>(  listOf(imgView_wheat_top, imgView_wheat_bottom), listOf(imgView_italianherb_top, imgView_italianherb_bottom),
                                            listOf(imgView_flat_top, imgView_flat_bottom), listOf(imgView_italian_top, imgView_italian_bottom))
        val cheeseImgList =  listOf<ImageView>(imgView_cheese_shredded, imgView_cheese_white, imgeView_cheese_mozza)


        onClickedOneMenuList(breadLengthImgList, "Bread Length")
        onClickedOneMenuList(breadTypeImgList)
        onClickedOneMenuList(cheeseImgList, "Cheese")


        btn_done.setOnClickListener {
            Toast.makeText(this, "Bread Length: ${menu?.breadLength}\nBread Type: ${menu?.breadType}\nCheese: ${menu?.cheese}", Toast.LENGTH_SHORT).show()
        }


    }
    private fun onClickedOneMenuList(imgList: List<ImageView>, string: String) {
        for((index, imageView) in imgList.withIndex()) {
            imageView.setOnClickListener {
                for(i in imgList.indices) {
                    if(i != index) {
                        imgList[i].setBackgroundColor(Color.TRANSPARENT)
                    } else {
                        imgList[i].setBackgroundColor(Color.GRAY)
                    }
                }
                when(string) {
                    "Bread Length" -> menu?.breadLength = BreadLength.values()[index]
                    "Cheese" -> menu?.cheese = CheeseType.values()[index]
                }

            }
        }
    }
    private fun onClickedOneMenuList(imgListSet: List<List<ImageView>>) {
        for((index, imageList) in imgListSet.withIndex()) {
            imageList[0].setOnClickListener {
                for(i in imgListSet.indices) {
                    if(i != index) {
                        imgListSet[i][0].setBackgroundColor(Color.TRANSPARENT)
                        imgListSet[i][1].setBackgroundColor(Color.TRANSPARENT)
                    } else {
                        imgListSet[i][0].setBackgroundColor(Color.GRAY)
                        imgListSet[i][1].setBackgroundColor(Color.GRAY)
                    }
                }
                menu!!.breadType = BreadType.values()[index]
            }
            imageList[1].setOnClickListener {
                for(i in imgListSet.indices) {
                    if(i != index) {
                        imgListSet[i][0].setBackgroundColor(Color.TRANSPARENT)
                        imgListSet[i][1].setBackgroundColor(Color.TRANSPARENT)
                    } else {
                        imgListSet[i][0].setBackgroundColor(Color.GRAY)
                        imgListSet[i][1].setBackgroundColor(Color.GRAY)
                    }
                }
                menu!!.breadType = BreadType.values()[index]
            }
        }
    }

    private fun onClickedMenuList(imgList: List<ImageView>, string: String, maxSelect: Int) {

    }
}