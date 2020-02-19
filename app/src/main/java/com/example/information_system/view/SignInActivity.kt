package com.example.information_system.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.information_system.R
import com.example.information_system.presenter.SignInPresenter
import com.google.android.material.tabs.TabLayout

class SignInActivity : AppCompatActivity(),ISignInActivity {
    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initViews()

        val signInPresenter=SignInPresenter(this@SignInActivity)

        
        signInPresenter.setViewPagerAdapter()
        signInPresenter.animateViewPager()


        tabLayout.setupWithViewPager(viewPager,true)

    }

    override fun initViews() {
        viewPager = findViewById(R.id.view_pager)
        tabLayout=findViewById(R.id.tabDots)
    }
}