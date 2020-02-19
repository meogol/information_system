package com.example.information_system.model

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.information_system.fragments.CommunicateFragment
import com.example.information_system.fragments.LearnFragment
import com.example.information_system.fragments.ReachFragment

@Suppress("DEPRECATION")
class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        val fragmentPos = position % 3;
        if (fragmentPos == 0) return LearnFragment()
        else if (fragmentPos == 1) return ReachFragment()
        else if (fragmentPos == 2) return CommunicateFragment()
        else return LearnFragment()
    }

    override fun getCount(): Int {
        return Int.MAX_VALUE
    }
}
