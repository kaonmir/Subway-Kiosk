package com.example.fuckingviewpagedamn

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_option_select.*

class OptionSelectActivity : AppCompatActivity() {
    var menu: Menu = Menu()

    private var vegetableList = mutableListOf<Int>()
    private var sourceList = mutableListOf<Int>()
    private fun init() {
        // bread Length
        setImage(imgView_bread_short, MyUrl("baguette_short.png", "option"))
        setImage(imgView_bread_long, MyUrl("baguette_long.png", "option"))
        //bread type
        setImage(imgView_wheat_top, MyUrl("bread_flat_top.png", "option"))
        setImage(imgView_wheat_bottom, MyUrl("bread_flat_bottom.png", "option"))
        setImage(imgView_italianherb_top, MyUrl("bread_italianherb_top.png", "option"))
        setImage(imgView_italianherb_bottom, MyUrl("bread_italianherb_bottom.png", "option"))
        setImage(imgView_flat_top, MyUrl("bread_flat_top.png", "option"))
        setImage(imgView_flat_bottom, MyUrl("bread_flat_bottom.png", "option"))
        setImage(imgView_italian_top, MyUrl("bread_italian_top.png", "option"))
        setImage(imgView_italian_bottom, MyUrl("bread_italian_bottom.png", "option"))
        //cheese
        setImage(imgView_cheese_shredded, MyUrl("cheeese_shredded.png", "option"))
        setImage(imgView_cheese_white, MyUrl("cheese_white.png", "option"))
        setImage(imgeView_cheese_mozza, MyUrl("cheese_mozza.png", "option"))
        //vegetables
        setImage(imgView_pickle, MyUrl("vegetable_pickle.png", "option"))
        setImage(imgView_cucumber, MyUrl("vegetable_cucumber.png", "option"))
        setImage(imgView_jelapeno, MyUrl("vegetable_jelapeno.png", "option"))
        setImage(imgView_olive, MyUrl("vegetable_olive.png", "option"))
        setImage(imgView_redonion, MyUrl("vegetable_redonion.png", "option"))
        setImage(imgView_lettuce, MyUrl("vegetable_lettuce.png", "option"))
        setImage(imgView_tomato, MyUrl("vegetable_tomato.png", "option"))
        setImage(imgView_pepper, MyUrl("vegetable_pepper.png", "option"))
        //sources
        setImage(imgView_bbq, MyUrl("source_bbq.png", "option"))
        setImage(imgView_caesear, MyUrl("source_caesear.png", "option"))
        setImage(imgView_southwest, MyUrl("source_southwest.png", "option"))
        setImage(imgView_mayonnaise, MyUrl("source_mayonnaise.png", "option"))
        setImage(imgView_oil, MyUrl("source_oil.png", "option"))
        setImage(imgView_ranch, MyUrl("source_ranch.png", "option"))
        setImage(imgView_sweetonion, MyUrl("source_sweetonion.png", "option"))
        setImage(imgView_mustard, MyUrl("source_mustard.png", "option"))

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_select)

        val breadLengthImgList = listOf<ImageView>(imgView_bread_short, imgView_bread_long)
        val breadTypeImgList
                = listOf<List<ImageView>> ( listOf(imgView_wheat_top, imgView_wheat_bottom), listOf(imgView_italianherb_top, imgView_italianherb_bottom),
            listOf(imgView_flat_top, imgView_flat_bottom), listOf(imgView_italian_top, imgView_italian_bottom))
        val cheeseImgList = listOf<ImageView>(imgView_cheese_shredded, imgView_cheese_white, imgeView_cheese_mozza)
        val vegetableImgList
                = listOf<ImageView>(imgView_pickle, imgView_cucumber, imgView_jelapeno,
            imgView_olive, imgView_redonion, imgView_lettuce,
            imgView_tomato, imgView_pepper)
        val sourceImgList
                = listOf<ImageView>(imgView_bbq, imgView_caesear, imgView_southwest,
            imgView_mayonnaise, imgView_oil, imgView_ranch,
            imgView_sweetonion, imgView_mustard)

        if(intent.hasExtra("menu")) menu = intent.getParcelableExtra("menu")!!
        else error("There is no menu intent!!!!!!!!")

        init()

        onClickedOneMenuList(breadLengthImgList, "Bread Length")
        onClickedOneMenuList(breadTypeImgList)
        onClickedOneMenuList(cheeseImgList, "Cheese")

        onClickedMenuList(vegetableImgList, "Vegetable", vegetableImgList.size)
        onClickedMenuList(sourceImgList, "Source", 3)

        btn_done.setOnClickListener {
            Toast.makeText(this, """
                |Bread Length: ${menu.breadLength}
                |Bread Type: ${menu.breadType}
                |Cheese: ${menu.cheese}
                |Vegetables: ${vegetableList.joinToString{"${VegetableType.values()[it]}"}}
                |Sources: ${sourceList.joinToString{"${SourceType.values()[it]}"}}
                """.trimMargin(), Toast.LENGTH_SHORT).show()

            menu.vegetables= vegetableList
            menu.sources = sourceList


            val intent = Intent()
            intent.putExtra("menu", menu)
            setResult(Activity.RESULT_OK, intent)
            println(intent.hasExtra("menu"))
            finish()
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
                    "Bread Length" -> menu.breadLength = BreadLength.values()[index]
                    "Cheese" -> menu.cheese = CheeseType.values()[index]
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
                menu.breadType = BreadType.values()[index]
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
                menu.breadType = BreadType.values()[index]
            }
        }
    }

    private fun onClickedMenuList(imgList: List<ImageView>, string: String, maxSelect: Int) {
        val ingredientList = when(string) {
            "Vegetable" -> vegetableList
            "Source" -> sourceList
            else -> error("Error is Error Yea!!")
        }
        for((index, imgView) in imgList.withIndex()) {
            imgView.setOnClickListener {
                when {
                    index in ingredientList -> {
                        ingredientList.removeAt(ingredientList.indexOf(index))
                        imgView.setBackgroundColor(Color.TRANSPARENT)
                    }
                    ingredientList.size < maxSelect -> {
                        ingredientList.add(index)
                        imgView.setBackgroundColor(Color.GRAY)
                    }
                    else -> Toast.makeText(this, "You have to choose at most $maxSelect", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun setImage(imgView: ImageView, url: MyUrl) {
        Thread(Runnable {
            run {
                runOnUiThread {
                    GlideApp.with(this).load(url.getImageurl()).into(imgView)
                }
            }
        }).start()
    }
}