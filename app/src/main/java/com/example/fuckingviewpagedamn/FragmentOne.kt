package com.example.fuckingviewpagedamn


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_menu.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        frameLayout1.addView(MenuPixel(R.drawable.black_forest_ham, "Black Forest", 1000, view.context))
        frameLayout2.addView(MenuPixel(R.drawable.cold_cut_combo_sandwich, "Cold Cut Combo", 1500, view.context))
        frameLayout3.addView(MenuPixel(R.drawable.classic_tuna, "Classic Tuna", 2000, view.context))
        frameLayout4.addView(MenuPixel(R.drawable.chicken_bacon_ranch_melt, "Chicken Bacon", 26000,  view.context))
        frameLayout5.addView(MenuPixel(R.drawable.italianbmt, "Italian B.M.T", 3000, view.context))
        frameLayout6.addView(MenuPixel(R.drawable.new_ultimate_steak, "New Ultimate Steak", 3500, view.context))
        frameLayout7.addView(MenuPixel(R.drawable.ovenroastedchicken_sandwiches, "Oven Roasted", 4000, view.context))
        frameLayout8.addView(MenuPixel(R.drawable.roastbeef_sandwiches, "Roast Beef", 4500, view.context))
        frameLayout9.addView(MenuPixel(R.drawable.rotisseriechicken_sandwiches, "Rotisserie",5000, view.context))
    }

}
