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


class ordering: Fragment(R.layout.order) {
    private lateinit var button: Button
    private lateinit var address: EditText
    private lateinit var date: EditText
    private lateinit var time: EditText
    private lateinit var button0: ImageButton
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.button30)
        address = view.findViewById(R.id.editTextTextPostalAddress)
        date = view.findViewById(R.id.editTextDate)
        time = view.findViewById(R.id.editTextTime)
        button0 = view.findViewById(R.id.imageButton43)

        button0.setOnClickListener{
            val esa = legalorgans()
            val fragmentManager = parentFragmentManager
            fragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment, esa)
            }
    }


        button.setOnClickListener{
            val postaladdress = address.text.toString()
            val daate = date.text.toString()
            val timee = time.text.toString()

            if(postaladdress.isEmpty() || daate.isEmpty() || timee.isEmpty() || daate.length < 10 || timee.length < 5){
                Toast.makeText(this@ordering.requireActivity(),"Please Make Sure All Fields Are Filled In Correctly",Toast.LENGTH_SHORT).show()
            }
            else{
                val back = Home()
                val fragmentManager = parentFragmentManager
                fragmentManager.commitNow {
                    setReorderingAllowed(true)
                    replace(R.id.nav_host_fragment,back)
                    Toast.makeText(this@ordering.requireActivity(),"Purchase Confirmed, See Ya Later!",Toast.LENGTH_SHORT).show()
                }
            }

        }
}
}