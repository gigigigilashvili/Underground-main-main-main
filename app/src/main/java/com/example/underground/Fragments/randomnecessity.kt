package com.example.underground.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.underground.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class randomnecessity:Fragment(R.layout.random_layout) {
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager2 = view.findViewById(R.id.viewPager2)
        tabLayout = view.findViewById(R.id.tabLayout)
        val tabTitle = arrayOf("Page 1","Page 2")
        val pager = viewPager2
        val tab = tabLayout
        pager.adapter = swipe(childFragmentManager,lifecycle)
        TabLayoutMediator(tab, pager){tab, position ->
            tab.text = tabTitle[position]
        }
    }
}