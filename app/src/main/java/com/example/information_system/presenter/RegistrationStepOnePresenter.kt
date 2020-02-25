package com.example.information_system.presenter

import android.content.Context
import com.example.information_system.view.activity.RegistrationActivity
import com.example.information_system.view.fragments.registration.RegistrationStepTwoFragment

class RegistrationStepOnePresenter(val context: Context):IRegistrationStepOnePresenter {
    override fun initFragments() {
        (context as RegistrationActivity).initFragment(
            RegistrationStepTwoFragment()
        )

    }
}