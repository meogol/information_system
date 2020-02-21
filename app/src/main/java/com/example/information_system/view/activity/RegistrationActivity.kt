package com.example.information_system.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.information_system.R
import com.example.information_system.view.fragments.RegistrationStepOneFragment
import com.example.information_system.view.fragments.RegistrationStepTwoFragment

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val toolbar = findViewById<Toolbar>(R.id.toolbar);//доделать
        setSupportActionBar(toolbar);
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        supportActionBar!!.setHomeButtonEnabled(true);
        supportActionBar!!.setDisplayShowTitleEnabled(false);
        toolbar.title = "Создание профиля";


        initFragment(RegistrationStepOneFragment())
    }

    fun initFragment(fragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        transaction.replace(R.id.fragment_container, fragment)

        transaction.commit()
    }
}