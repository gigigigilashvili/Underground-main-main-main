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
import com.example.underground.dataa.RealtimeData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class LogInLegally:Fragment(R.layout.legal) {
    private lateinit var button: Button
    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var repeatpass:EditText
    private lateinit var name: EditText
    private lateinit var lastname: EditText
    private lateinit var imagebutton: ImageButton
    private val databasee = FirebaseDatabase.getInstance().getReference("Momxmareblebi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.button5)
        email = view.findViewById(R.id.editTextTextEmailAddress)
        pass = view.findViewById(R.id.editTextTextPassword)
        repeatpass = view.findViewById(R.id.editTextTextPassword2)
        imagebutton = view.findViewById(R.id.imageButton2)
        name = view.findViewById(R.id.Name)
        lastname = view.findViewById(R.id.Lastname)

        imagebutton.setOnClickListener{
            val esa = Home()
            val fragmentManager = parentFragmentManager
            fragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment, esa)
            }
        }
        button.setOnClickListener{
            val eemail = email.text.toString()
            val passs = pass.text.toString()
            val pass2 = repeatpass.text.toString()
            val namee = name.text.toString()
            val lastnamee = lastname.text.toString()
            if (eemail.isEmpty() || passs.isEmpty() || pass2.isEmpty() || namee.isEmpty() || lastnamee.isEmpty() || passs != pass2){
                Toast.makeText(this@LogInLegally.requireActivity(),"invalid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(eemail, passs)
                .addOnCompleteListener{
                        task -> if(task.isSuccessful) {
                            Toast.makeText(this@LogInLegally.requireActivity(),"User Successfully Created",Toast.LENGTH_SHORT).show()
                    val loginl = signin()
                    val fragmentManager = parentFragmentManager
                    fragmentManager.commitNow {
                        setReorderingAllowed(true)
                        replace(R.id.nav_host_fragment, loginl)
                    }
                    val user = RealtimeData(name.text.toString(), lastname.text.toString(), email.text.toString())
                    val database = FirebaseDatabase.getInstance().getReference("Momxmareblebi")
                    database.push().setValue(user)
                }
                else{
                    Toast.makeText(this@LogInLegally.requireActivity(),"Something went wrong", Toast.LENGTH_SHORT).show() }
                }
        }
    }
}