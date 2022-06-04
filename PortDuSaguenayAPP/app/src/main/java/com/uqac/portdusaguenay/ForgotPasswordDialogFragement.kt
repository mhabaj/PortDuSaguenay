package com.uqac.portdusaguenay

import android.view.LayoutInflater
import java.util.zip.Inflater
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_log_in.view.*
import kotlinx.android.synthetic.main.fragment_dialog_forgot_pass.view.*

class ForgotPasswordDialogFragement :DialogFragment() {

    private var m_email: EditText? = null
    private val TAG="My activity"
    private var m_resultat: TextView? = null

    override fun onCreateView( inflater: LayoutInflater,
                               container:ViewGroup?, saveInstanceState :Bundle? ):View ?
    {

        var rootView : View = inflater.inflate(R.layout.fragment_dialog_forgot_pass, container, false)

        m_email = rootView.findViewById<EditText>(R.id.emailReset)
        m_resultat = rootView.findViewById<TextView>(R.id.textResultat)

        rootView.cancelButton.setOnClickListener{
            dismiss()
        }

        rootView.acceptButton.setOnClickListener {
            FirebaseAuth.getInstance().sendPasswordResetEmail(m_email?.text.toString().trim()).addOnSuccessListener {
                Log.d(TAG, "Reset Link sent to your Email")
                dismiss()
            }.addOnFailureListener{ e ->
                Log.d(TAG, "Error !! reset Link is not sent. " + e.message)
                m_resultat?.text= "Error !! reset Link is not sent. " + e.message
                m_resultat?.visibility = View.VISIBLE

            }


        }

        return rootView
    }


}