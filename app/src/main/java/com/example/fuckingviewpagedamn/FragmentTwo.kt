package com.example.fuckingviewpagedamn


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_menu.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentTwo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        frameLayout1.addView(MenuPixel("steakcheese_sandwiches.jpg", "Steak & Cheese", 10000, view.context))
        frameLayout2.addView(MenuPixel("turkeybreast.jpg", "Turkey Breast", 11000, view.context))
        frameLayout3.addView(MenuPixel("subclub.jpg", "Subway Club", 12000, view.context))
        frameLayout4.addView(MenuPixel("ultimate_meatball_marinara.jpg", "Turkey Breast ", 13000, view.context))
        frameLayout5.addView(MenuPixel("ultimate_spicy_italian.jpg", "Spicy Italian", 14000, view.context))
        frameLayout6.addView(MenuPixel("veggiedelite_sandwiches.jpg", "Veggie Delite", 15000, view.context))
    }

}
