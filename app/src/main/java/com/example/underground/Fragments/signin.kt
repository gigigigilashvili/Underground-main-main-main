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

class signin:Fragment(R.layout.signinn) {
    private lateinit var mail: EditText
    private lateinit var pass: EditText
    private lateinit var signinn: Button
    private lateinit var forgpass:  Button
    private lateinit var imagebutton: ImageButton
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mail = view.findViewById(R.id.editTextTextEmailAddress2)
        pass = view.findViewById(R.id.editTextTextPassword3)
        signinn = view.findViewById(R.id.button6)
        forgpass = view.findViewById(R.id.button7)
        imagebutton = view.findViewById(R.id.imageButton3)

        imagebutton.setOnClickListener {
            val back = Home()
            val fragmentManager = parentFragmentManager
            fragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment, back)
            }
        }

        forgpass.setOnClickListener{
            val forg = forgotUwU()
            val fragmentManager = parentFragmentManager
            fragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment, forg)
            }
        }
        signinn.setOnClickListener{
            val email = mail.text.toString()
            val password = pass.text.toString()
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener{
                        task -> if(task.isSuccessful) {
                    val legalUwU = legalorgans()
                    val fragmentManager = parentFragmentManager
                    fragmentManager.commitNow {
                        setReorderingAllowed(true)
                        replace(R.id.nav_host_fragment, legalUwU)
                        Toast.makeText(
                            this@signin.requireActivity(),
                            "Welcome To The Board",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                    }
            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this@signin.requireActivity(),"Nice Try, Next Time Try Harder",Toast.LENGTH_SHORT).show()
            }
                    }
                }
        }
