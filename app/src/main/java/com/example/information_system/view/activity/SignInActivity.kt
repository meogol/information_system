package com.example.information_system.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.information_system.R
import com.example.information_system.presenter.SignInPresenter
import com.google.android.material.tabs.TabLayout

class SignInActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout
    private lateinit var bLogIn: Button
    private lateinit var bRegistration: Button
    private lateinit var signInPresenter: SignInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initViews()

        signInPresenter = SignInPresenter(this@SignInActivity)
        bLogIn = findViewById(R.id.login_button)
        bRegistration = findViewById(R.id.create_account_button)

        signInPresenter.setViewPagerAdapter()
        signInPresenter.animateViewPager()


        tabLayout.setupWithViewPager(viewPager, true)

        bLogIn.setOnClickListener {
            startActivity(Intent(this, LogInActivity().javaClass))
        }
        bRegistration.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity().javaClass))
        }

    }


    fun initViews() {
        viewPager = findViewById(R.id.pager)
        tabLayout = findViewById(R.id.tabDots)
    }


}