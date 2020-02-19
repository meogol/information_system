package com.example.information_system.model

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.information_system.view.fragments.CommunicateFragment
import com.example.information_system.view.fragments.LearnFragment
import com.example.information_system.view.fragments.ReachFragment

@Suppress("DEPRECATION")
class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        if (position == 0) return LearnFragment()
        else if (position == 1) return ReachFragment()
        else return CommunicateFragment()
    }

    override fun getCount(): Int {
        return 3
    }
}
