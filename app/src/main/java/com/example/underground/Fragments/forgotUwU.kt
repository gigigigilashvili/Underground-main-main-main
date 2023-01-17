package com.example.underground.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commitNow
import com.example.underground.R
import com.google.firebase.auth.FirebaseAuth

class forgotUwU:Fragment(R.layout.forgot_password) {
    private lateinit var mail: EditText
    private lateinit var reset: Button
    private lateinit var baack: ImageButton
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mail = view.findViewById(R.id.editTextTextEmailAddress3)
        reset = view.findViewById(R.id.button10)
        baack = view.findViewById(R.id.imageButton63)

        baack.setOnClickListener{
            val donkey = Home()
            val fragmentManager = parentFragmentManager
            fragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment, donkey)
            }
        }



        reset.setOnClickListener{
            val email = mail.text.toString()
            if (email.isEmpty()){
                Toast.makeText(this@forgotUwU.requireActivity(),"Input Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener{task ->
                    if(task.isSuccessful){
                        Toast.makeText(this@forgotUwU.requireActivity(), "Recovery link sent, Check Email", Toast.LENGTH_SHORT).show()
                        val isa = Home()
                        val fragmentManager = parentFragmentManager
                        fragmentManager.commitNow {
                            setReorderingAllowed(true)
                            replace(R.id.nav_host_fragment, isa)
                        }
                    }
                    else {
                        Toast.makeText(this@forgotUwU.requireActivity(), "Account Isn't Registered", Toast.LENGTH_SHORT).show()
                    }
                }


        }

    }
}