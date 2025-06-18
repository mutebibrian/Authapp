package com.manstercode.authapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance

        findViewById<Button>(R.id.loginbtn).setOnClickLister{

        val email = findViewById<EditText>(R.id.etEmail).text.toString()
        val password = findViewById<EditText>(R.id.etPassword).text.toString()

        auth.SignInWithEmailAndPassword(email,password).addOnCompleteListenerP{
            if (it.isSucessful){
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show()
            }

        }
        }
    findViewById<TextView>(R.id.signup).setOnClickListener{
        startActivity(Intent(this,.MainActivity::class.java))
    }
    }

}