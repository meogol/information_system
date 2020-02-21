package com.example.information_system.model

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.information_system.view.fragments.viewpagerFragments.CommunicateFragment
import com.example.information_system.view.fragments.viewpagerFragments.LearnFragment
import com.example.information_system.view.fragments.viewpagerFragments.ReachFragment

@Suppress("DEPRECATION")
class PagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        val fragmentPos = position % 3;
        if (fragmentPos == 0) {
            return LearnFragment()
        } else if (fragmentPos == 1) {
            return ReachFragment()
        } else if (fragmentPos == 2) {
            return CommunicateFragment()
        } else {
            return LearnFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}
