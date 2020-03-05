package com.example.information_system.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.view.MenuItem
import android.widget.ImageButton

import androidx.appcompat.widget.Toolbar
import com.example.information_system.R
import com.example.information_system.view.coordinator.RegistrationCoordinator
import com.example.information_system.view.fragments.dialogFragments.PasswordResetDialogFragment

private lateinit var bForgot: Button
private lateinit var bLogin: Button
private lateinit var bGoogleAuth: ImageButton
private lateinit var bVkAuth: ImageButton

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

    private fun initViews() {
        bForgot = findViewById(R.id.forgot_btn)
        bLogin = findViewById(R.id.login_btn)
        bGoogleAuth = findViewById(R.id.google_ib)
        bVkAuth = findViewById(R.id.vk_ib)
    }

    private fun initClickers() {
        bForgot.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            val prev = supportFragmentManager.findFragmentByTag("reset_pass")
            if (prev != null) {
                fragmentTransaction.remove(prev)
            }
            fragmentTransaction.addToBackStack(null)
            val dialogFragment = PasswordResetDialogFragment()
            dialogFragment.show(fragmentTransaction, "reset_pass")
        }

        bLogin.setOnClickListener {
            val intent =
                Intent(this, MainActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }

        bVkAuth.setOnClickListener{
            RegistrationCoordinator().VKAuth().signIn(this@LogInActivity)
        }

        bGoogleAuth.setOnClickListener {
            RegistrationCoordinator().GoogleAuth().signIn(this, this@LogInActivity)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        RegistrationCoordinator().resultAuth(this, requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        return super.onOptionsItemSelected(item);
    }
}