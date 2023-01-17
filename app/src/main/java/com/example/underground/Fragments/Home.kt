package com.example.underground.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commitNow
import com.example.underground.R

class Home: Fragment(R.layout.home) {
    private lateinit var button:Button
    private lateinit var button1:Button
    private lateinit var button2:Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.button)
        button1 = view.findViewById(R.id.button2)
        button2 = view.findViewById(R.id.button3)

        button.setOnClickListener{
            val legaluri = LogInLegally()
            val fragmentManager = parentFragmentManager
            fragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment, legaluri)
            }
        }
        button1.setOnClickListener{
            val aralegaluri = LogInillegally()
            val fragmentManager = parentFragmentManager
            fragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment, aralegaluri)
            }
        }
        button2.setOnClickListener{
            val sign = signin()
            val fragmentManager = parentFragmentManager
            fragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment, sign)
            }
        }
    }
}