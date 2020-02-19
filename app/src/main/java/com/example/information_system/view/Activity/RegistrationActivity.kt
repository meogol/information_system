package com.example.information_system.view.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.information_system.R
import com.example.information_system.view.fragments.RegistrationStepOneFragment

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        initFragment(RegistrationStepOneFragment())
    }

    fun initFragment(fragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        transaction.replace(R.id.fragment_container,fragment)

        transaction.commit()
    }
}