package com.example.underground.Fragments

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.underground.R

class testing:Fragment(R.layout.tester) {
    private lateinit var enter: Button
    private lateinit var type: EditText
    private lateinit var input: TextView
    private lateinit var positive: Button
    private lateinit var negative: Button
    private lateinit var sharedPreferences: SharedPreferences
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enter = view.findViewById(R.id.Enter)
        type = view.findViewById(R.id.type)
        input = view.findViewById(R.id.input)
        sharedPreferences = requireActivity().getSharedPreferences("BloodTypes", Context.MODE_PRIVATE)
        val notess = sharedPreferences.getString("NOTE","")
        input.text = notess


        enter.setOnClickListener{
            val nnote = type.text.toString()
            val notes = input.text.toString()
            val result = nnote + "\n" + notes
            input.text = result
            type.setText("")
            sharedPreferences.edit()
                .putString("NOTE", result)
                .apply()
            if(nnote == "A" || nnote == "B" || nnote == "AB" || nnote == "O"){
                bloody()
            }
            else{
                Toast.makeText(this@testing.requireActivity(),"Invalid Blood Type", Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun bloody(){
        val dialog = LayoutInflater.from(this.context).inflate(R.layout.positiveornegative, null)
        val bBuilder = AlertDialog.Builder(this.context)
            .setView(dialog)
            .setTitle("Donation")
        val bAlertDialog = bBuilder.show()


        positive = dialog.findViewById(R.id.Positive)
        negative = dialog.findViewById(R.id.Negative)


        positive.setOnClickListener{
            Toast.makeText(this@testing.requireActivity(), "Thank You For The Commitment", Toast.LENGTH_SHORT).show()
            bAlertDialog.dismiss()
        }
        negative.setOnClickListener{
            Toast.makeText(this@testing.requireActivity(), "Thank You For The Commitment", Toast.LENGTH_SHORT).show()
            bAlertDialog.dismiss()
        }

    }

}