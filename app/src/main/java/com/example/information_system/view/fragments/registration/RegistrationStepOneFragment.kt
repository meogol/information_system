package com.example.information_system.view.fragments.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.information_system.R
import com.example.information_system.presenter.RegistrationStepOnePresenter
import com.example.information_system.view.activity.RegistrationActivity
import com.example.information_system.view.coordinator.RegistrationCoordinator
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationStepOneFragment : Fragment(), IRegistrationStepOneFragment {


    private lateinit var bStepTwo: Button
    private lateinit var googleRegBtn: ImageButton
    private lateinit var vkRegBtn: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            LayoutInflater.from(container!!.context).inflate(
                R.layout.fragment_registration_step_one,
                container, false
            )
        googleRegBtn=view.findViewById(R.id.google_ib)
        vkRegBtn=view.findViewById(R.id.vk_ib)
        initViews(view)
        setToolbarTitle()
        bStepTwo.setOnClickListener {
            RegistrationStepOnePresenter(container.context).initFragments()
        }
        googleRegBtn.setOnClickListener(){
            RegistrationCoordinator().GoogleAuth().signIn(container.context,activity as RegistrationActivity)
        }
        vkRegBtn.setOnClickListener(){
            RegistrationCoordinator().VKAuth().signIn(activity as RegistrationActivity)
        }
        return view
    }

    override fun initViews(view: View) {
        bStepTwo = view.findViewById(R.id.b_next_step)
    }

    override fun setToolbarTitle() {
        (context as RegistrationActivity).toolbar.title = "Создание профиля"
    }
}