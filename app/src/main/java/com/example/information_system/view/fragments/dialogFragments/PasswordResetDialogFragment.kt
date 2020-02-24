package com.example.information_system.view.fragments.dialogFragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.information_system.R


private lateinit var tvSend: TextView
private lateinit var tvCancel: TextView

class PasswordResetDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return super.onCreateDialog(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_reset_password, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.MyDialog)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvSend = view.findViewById<TextView>(R.id.df_tv_ok)!!
        tvSend.setOnClickListener {
            replaceDialogFragment()
        }
        tvCancel = view.findViewById<TextView>(R.id.df_tv_cancel)
        tvCancel.setOnClickListener {
            closeDialogFragment()
        }
    }

    private fun closeDialogFragment() {
        val ft: FragmentTransaction? = fragmentManager?.beginTransaction()
        val fragmentToRemove: Fragment? = fragmentManager?.findFragmentByTag("reset_pass")
        if (fragmentToRemove != null) {
            ft?.remove(fragmentToRemove)
        }
        ft?.addToBackStack(null)
        ft?.commit()
    }

    private fun replaceDialogFragment() {
        closeDialogFragment()
        val dgEmailSent = SentEmailDialogFragment()
        dgEmailSent.show(fragmentManager!!, "email_sent")
    }
}
