package com.example.myhobby.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myhobby.R

class SecondFragment:Fragment() {
        override fun onCreateView(//view를 넣어주는 역할을
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.fragment_second,container,false)
        }
        fun newInstant() : SecondFragment
        {
            val args = Bundle()
            val frag = SecondFragment()
            frag.arguments = args
            return frag
        }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            class MainActivity : AppCompatActivity()
        }

    }
