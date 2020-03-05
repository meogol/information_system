package com.example.information_system.view.activity

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.information_system.R
import com.example.information_system.view.fragments.registration.RegistrationStepOneFragment
import com.example.information_system.view.fragments.registration.RegistrationStepTwoFragment

class RegistrationActivity : AppCompatActivity() {
    private var count = 0

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        return super.onOptionsItemSelected(item);
    }

    fun initFragment(fragment: Fragment) {
        count++
        if (fragment is RegistrationStepTwoFragment)
            Log.e("frag", "true")
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
            .addToBackStack("stepOne")
            .commit()
    }

    override fun onBackPressed() {
        count--
        if (count <= 0)
            super.onBackPressed()

        super.onBackPressed()

    }

}