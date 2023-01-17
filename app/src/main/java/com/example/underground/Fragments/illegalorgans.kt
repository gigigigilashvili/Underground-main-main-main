package com.example.underground.Fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commitNow
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.underground.R
import com.example.underground.adaptervol2.Adapter
import com.example.underground.datavol2.Dataforadapter

class illegalorgans:Fragment(R.layout.illorgans) {
    private lateinit var newRecyclerView1: RecyclerView
    private lateinit var newArrayList1: ArrayList<Dataforadapter>
    lateinit var profile: Array<Int>
    lateinit var price: Array<String>
    lateinit var description: Array<String>
    lateinit var name: Array<String>
    private lateinit var imagebutton: ImageButton
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profile = arrayOf(
            R.drawable.travellikespy,
            R.drawable._5a1fb6e440b9c62cc521a9384b239e7,
            R.drawable.spy_png12,
            R.drawable.spy_png18,
            R.drawable.spies,
            R.drawable.lee_allgood_spy,
            R.drawable.shrek_aufmacher_bm_lifestyle_seeburg_jpg,
            R.drawable.istockphoto_1171546024_612x612,
            R.drawable.pngimg_com___postman_png21
        )
        name = arrayOf(
            "Jax",
            "Léa",
            "Pogger",
            "Francesco",
            "KVIIIlyn",
            "ავჭალა",
            "NotShrek",
            "Guts",
            "შვედი"
        )
        description = arrayOf(
            "Lungs. New Pair. 00:00 Underground Of New York.",
            "Ho bisogno di tre occhi, 04:00 A due passi dalla metro di Firenze.",
            "მჭირდება ძაღლის ღვიძლი. 06:00 ვარკეთილის მეტროსთან, დაგინახავ.",
            "j'ai besoin d'un pancréas, 04:00 Dans le métro international français.",
            "I Desire 4 First Fingers. 05:30 Washington Metro.",
            "კაცის ტვინი მინდა, 23:00 ავჭალაში არა.",
            "Female Donkey, 17:45 In My Swamp.",
            "Hands, I Need Them To Become Handsome, 02:00 MBTA subway",
            "30-40 წლის კაცის კუჭი, 03:37 ვაჟა-ფშაველას მეტრო."
        )
        price = arrayOf(
            "1,500,963.85$",
            "6,500$",
            "1,200$",
            "160,000$",
            "40,000$",
            "1,950,000,00$",
            "Shrek Cookies",
            "1,750$",
            "38,000$"
        )
        newRecyclerView1 = view.findViewById(R.id.recyclerViewMenu1)
        newRecyclerView1.layoutManager = LinearLayoutManager(this.requireActivity())
        newRecyclerView1.setHasFixedSize(true)

        newArrayList1 = arrayListOf<Dataforadapter>()
        getUserdata()



        imagebutton = view.findViewById(R.id.imageButton21)
        imagebutton.setOnClickListener{
            val esa = Home()
            val fragmentManager = parentFragmentManager
            fragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment, esa)
            }
        }
        }
    private fun getUserdata() {
        for(i in profile.indices){

            val data = Dataforadapter(profile[i],name[i],description[i],price[i])
            newArrayList1.add(data)
        }

        var adapter = Adapter(newArrayList1)
        newRecyclerView1.adapter = adapter
        adapter.SetOnItemClicker(object : Adapter.SetOnItemClicker{
            override fun onItemClicker(position: Int) {
                val taken = Home()
                val fragmentManager = parentFragmentManager
                fragmentManager.commitNow {
                    setReorderingAllowed(true)
                    replace(R.id.nav_host_fragment,taken)
                    Toast.makeText(this@illegalorgans.requireActivity(),"You Took The Order, Better Make It In Time!",Toast.LENGTH_SHORT).show()
                }
            }
        })

    }
}