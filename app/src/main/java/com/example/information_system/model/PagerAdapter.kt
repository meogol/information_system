package com.example.information_system.model

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.information_system.view.fragments.viewpagerFragments.CommunicateFragment
import com.example.information_system.view.fragments.viewpagerFragments.LearnFragment
import com.example.information_system.view.fragments.viewpagerFragments.ReachFragment
import java.util.*

@Suppress("DEPRECATION")
class PagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    var mFrags: ArrayList<Fragment> = arrayListOf(LearnFragment(),ReachFragment(),CommunicateFragment())


    override fun getItem(position: Int): Fragment {
        val index = position % mFrags.size
        return mFrags[index]
    }

    override fun getCount(): Int {
        return 3
    }
}
