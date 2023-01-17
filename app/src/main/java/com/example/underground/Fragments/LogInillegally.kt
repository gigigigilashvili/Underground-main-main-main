package com.example.underground.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commitNow
import com.example.underground.R

class LogInillegally:Fragment(R.layout.illegal) {
    private lateinit var note: EditText
    private lateinit var add:Button
    private lateinit var text: TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add = view.findViewById(R.id.button4)
        note = view.findViewById(R.id.editTextTextPersonName2)
        text = view.findViewById(R.id.textView12)

        add.setOnClickListener{
            val nnote = note.text.toString()
            val notes = text.text.toString()
            val result = nnote + "\n" + notes
            text.text = result
            note.setText("")
            if(nnote == "underground"){
                val illegaluri = illegalorgans()
                val fragmentManager = parentFragmentManager
                fragmentManager.commitNow {
                    setReorderingAllowed(true)
                    replace(R.id.nav_host_fragment, illegaluri)
                }
            }
            else{
                val incorrect = Home()
                val fragmentManager = parentFragmentManager
                fragmentManager.commitNow {
                    setReorderingAllowed(true)
                    replace(R.id.nav_host_fragment,incorrect)
                }
                Toast.makeText(this@LogInillegally.requireActivity(),"You Are A Potato",Toast.LENGTH_SHORT).show()
            }
        }
    }
}