package com.manstercode.authapp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_main)
        auth =FirebaseAuth.getInstance()
        findViewById<Button>(R.id.signupbtn).setOnClickListener{
            val email =findViewById<EditText>(R.id.etemail).text.toString()
            val password = findViewById<EditText>(R.id.etpassword).text.toString()

            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){
                //addonCompleteListener{..}This checks if the fiebase operation is successful or not
                if (it.isSuccessful) {
                    Toast.makeText(this, "Signed up successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show()

                }

                }


        }

    }
}