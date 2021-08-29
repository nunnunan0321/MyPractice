package com.example.myhobby.fragment

import android.bluetooth.BluetoothDevice
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myhobby.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirstFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first,container,false)
    }
    fun newInstant():FirstFragment{
        val args=Bundle()
        val frag=FirstFragment()
        frag.arguments=args

        return frag
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        class MainActivity:AppCompatActivity()

        @IgnoreExtraProperties
        data class User(val username: String? = null, val email: String? = null) {
            // Null default values create a no-argument default constructor, which is needed
            // for deserialization from a DataSnapshot.
        }

        val database=Firebase.database
        val myRef=database.getReference("message")
        val floating:View=view.findViewById(R.id.floating_first_write)

        var count:Int=1

        floating.setOnClickListener{
            myRef.setValue("${count} Click")
            Snackbar.make(view,"${count} Click",Snackbar.LENGTH_SHORT)
                .show()
            count++

        }


    }
}
