package com.example.information_system.view.fragments.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.example.information_system.R
import com.example.information_system.view.activity.RegistrationActivity
import kotlinx.android.synthetic.main.activity_registration.*

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
        (context as RegistrationActivity).toolbar.title="Заполнение личных данных"
        return view
    }

}