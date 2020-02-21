package com.example.information_system.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.example.information_system.R

class RegistrationStepTwoFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=
            LayoutInflater.from(container!!.context).inflate(R.layout.fragment_registration_step_two,
                container,false)
        val manRB:RadioButton=view.findViewById(R.id.rb_man)
        val womanRB:RadioButton=view.findViewById(R.id.rb_woman)
        manRB.setOnClickListener(){
            if (manRB.isChecked==true) womanRB.isChecked=false
        }
        womanRB.setOnClickListener(){
            if (womanRB.isChecked==true) manRB.isChecked=false
        }
        return view
    }
}