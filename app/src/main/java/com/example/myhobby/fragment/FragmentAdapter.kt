package com.example.myhobby.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        val fragment = when(position){
            0-> FirstFragment().newInstant()
            1-> SecondFragment().newInstant()
            2-> ThirdFragment().newInstant()
            3-> FourthFragment().newInstant()
            else-> FirstFragment().newInstant()
        }
        return fragment
    }

    override fun getCount(): Int=4
}