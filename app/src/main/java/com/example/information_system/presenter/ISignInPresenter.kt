package com.example.information_system.presenter

import com.example.information_system.model.PagerAdapter

interface ISignInPresenter {
    fun animateViewPager()
    fun initPagerAdapter(): PagerAdapter
    fun setViewPagerAdapter()
}