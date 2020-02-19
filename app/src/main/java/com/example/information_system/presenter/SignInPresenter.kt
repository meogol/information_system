package com.example.information_system.presenter

import com.example.information_system.model.PagerAdapter
import com.example.information_system.view.Activity.SignInActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SignInPresenter(val signInActivity: SignInActivity):ISignInPresenter {
    override fun animateViewPager() {
        CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                for (i in 0..2) {
                    delay(3000)
                    signInActivity.viewPager.currentItem = i
                }
            }

        }
    }

    override fun initPagerAdapter(): PagerAdapter {
        val fragmentAdapter =
            com.example.information_system.model.PagerAdapter(
                signInActivity.supportFragmentManager
            )
        return fragmentAdapter
    }

    override fun setViewPagerAdapter() {
        val adapter=initPagerAdapter()
        signInActivity.viewPager.adapter=adapter
    }
}