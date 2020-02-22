package com.example.information_system.view.fragments.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.information_system.R
import com.example.information_system.view.activity.RegistrationActivity

class RegistrationStepOneFragment: Fragment() {
    private lateinit var bStepTwo: Button
    private lateinit var bBeck: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=
            LayoutInflater.from(container!!.context).inflate(R.layout.fragment_registration_step_one,
                container,false)

        bStepTwo = view.findViewById(R.id.b_next_step)

        bStepTwo.setOnClickListener {
            (container.context as RegistrationActivity).initFragment(RegistrationStepTwoFragment())
        }

        return view
    }
}