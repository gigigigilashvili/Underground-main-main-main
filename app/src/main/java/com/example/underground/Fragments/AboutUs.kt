package com.example.underground.Fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.underground.R

class AboutUs:Fragment(R.layout.aboutus) {
    private lateinit var imageButton: ImageButton
    private lateinit var donateButton:Button
    private lateinit var cancelButton: Button
    private lateinit var heart: RadioButton
    private lateinit var lungs: RadioButton
    private lateinit var brain: RadioButton
    private lateinit var stomach: RadioButton
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageButton = view.findViewById(R.id.imageButton)

        imageButton.setOnClickListener{
            dialogue()
        }
    }

    private fun dialogue(){
        val dialog = LayoutInflater.from(this.context).inflate(R.layout.dialogue, null)
        val nBuilder = AlertDialog.Builder(this.context)
            .setView(dialog)
            .setTitle("Donation")
        val nAlertDialog = nBuilder.show()


        heart = dialog.findViewById(R.id.Heart)
        lungs = dialog.findViewById(R.id.Lungs)
        brain = dialog.findViewById(R.id.Brain)
        stomach = dialog.findViewById(R.id.Stomach)
        donateButton = dialog.findViewById(R.id.Donatee)
        cancelButton = dialog.findViewById(R.id.Cancel)


        donateButton.setOnClickListener{
            if(heart.isChecked || lungs.isChecked || brain.isChecked || stomach.isChecked){
                Toast.makeText(this@AboutUs.context, "Swipe left For More Details.", Toast.LENGTH_SHORT).show()
                nAlertDialog.dismiss()
            }
            else{
                Toast.makeText(this@AboutUs.context,"We Are Not Giving Out Free Thankses, Shrek", Toast.LENGTH_SHORT).show()
                nAlertDialog.dismiss()
            }
        }
        cancelButton.setOnClickListener{
            Toast.makeText(this@AboutUs.context,"Jerk!",Toast.LENGTH_SHORT).show()
            nAlertDialog.dismiss()
        }

    }
}
