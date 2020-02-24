package com.example.information_system.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.information_system.R
import kotlinx.android.synthetic.main.activity_main.*

private const val SPLASH_DURATION = 500

private lateinit var navController: NavController
private lateinit var animation: Animation
private lateinit var progressBar: ProgressBar
private lateinit var splashLayout: ConstraintLayout
private lateinit var mainLayout: ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_splash)
        splashLayout = findViewById(R.id.splash_layout)
        progressBar = findViewById(R.id.splash_progress_bar)
        animation = AnimationUtils.loadAnimation(baseContext, R.anim.rotate)
    }

    private fun setupNavigationDrawer() {
        navController = Navigation.findNavController(this, R.id.fragment_container)
        bottom_navigation_bar.setupWithNavController(navController)
    }

    private fun initFunctionality() {
        splashLayout.postDelayed({
            progressBar.visibility = View.GONE
            splashLayout.visibility = View.GONE
            updateUI()
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}

                override fun onAnimationRepeat(animation: Animation) {}

                override fun onAnimationEnd(animation: Animation) {
                    updateUI()
                }
            })
        }, SPLASH_DURATION.toLong())
    }

    private fun updateUI() {
        setContentView(R.layout.activity_main)
        setupNavigationDrawer()
        mainLayout = findViewById(R.id.main_layout)
    }

    override fun onResume() {
        super.onResume()
        initFunctionality()
    }
}