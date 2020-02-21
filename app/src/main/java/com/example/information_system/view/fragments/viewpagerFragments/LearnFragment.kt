package com.example.information_system.view.fragments.viewpagerFragments

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.information_system.R

class LearnFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(container!!.context)
            .inflate(R.layout.fragment_learn, container, false)
        val roboto = Typeface.createFromAsset(
            context!!.assets,
            "fonts/Roboto-Regular.ttf"
        )
        val learnTV:TextView=view.findViewById(R.id.learn_tv)
        learnTV.typeface=roboto

        return view
    }
}