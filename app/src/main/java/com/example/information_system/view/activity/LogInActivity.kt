package com.example.information_system.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.information_system.R
import com.example.information_system.view.fragments.dialogFragments.PasswordResetDialogFragment

private lateinit var bForgot: Button
private lateinit var bLogin: Button

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val toolbar = findViewById<Toolbar>(R.id.login_toolbar)
        setSupportActionBar(toolbar);

        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        supportActionBar!!.setHomeButtonEnabled(true);
        supportActionBar!!.setDisplayShowTitleEnabled(false);
        toolbar.title = "Войти"

        initViews()
        initClickers()
    }
}