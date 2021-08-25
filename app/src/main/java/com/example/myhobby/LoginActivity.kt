package com.example.myhobby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth= FirebaseAuth.getInstance()
        val btn_main_login: Button =findViewById(R.id.btn_main_login)
        val edt_main_email:EditText=findViewById(R.id.edt_main_email)
        val edt_main_pass:EditText=findViewById(R.id.edt_main_pass)
        val txt_main_register:TextView=findViewById(R.id.txt_main_registter)
        val user=auth.currentUser

        if(user!=null){
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        txt_main_register.setOnClickListener(){
            val intent= Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
        btn_main_login.setOnClickListener{
            auth.signInWithEmailAndPassword(edt_main_email.text.toString(),edt_main_pass.text.toString())
                .addOnCompleteListener(this){task->
                    if(task.isSuccessful){
                        val intent=Intent(this,MainActivity::class.java)
                        Toast.makeText(applicationContext,"로그인에 성공하였습니다.",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(applicationContext,"로그인에 실패하였습니다.",Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
}