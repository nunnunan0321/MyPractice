package com.example.myhobby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth=FirebaseAuth.getInstance()

        val btn_serve_regi: Button =findViewById(R.id.btn_serve_regi)
        val edt_serve_email:EditText=findViewById(R.id.edt_serve_email)
        val edt_serve_pass:EditText=findViewById(R.id.edt_serve_pass)
        val edt_serve_name:EditText=findViewById(R.id.edt_serve_name)

        btn_serve_regi.setOnClickListener(){
            auth.createUserWithEmailAndPassword(edt_serve_email.text.toString(),edt_serve_pass.text.toString())
                .addOnCompleteListener(this){task->
                    if(task.isSuccessful){
                        Toast.makeText(applicationContext,"회원가입에 성공했습니다.",Toast.LENGTH_SHORT).show()
                        val intent= Intent(this,LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(applicationContext,"회원가입에 실패하였습니다.",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}