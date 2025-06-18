package com.manstercode.authapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var db:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main2)

        auth = FirebaseAuth.getInstance()
        // Initialize FirebaseAuth
        db = FirebaseeDatabase.getInstance().reference
        // Initialize FirebaseDatabase reference

        findViewById<Button>(R.id.signupbtn).setOnclickListner{

            val username = findViewById<EditText>(R.id.etusername).text.toString().trim()
            val email = findViewById<EditText>(R.id.etemail).text.toString().trim()
            val password = findViewById<EditText>(R.id.etpassword).text.toString().trim()
            //Trim () Removes any leading or trailing white spaces from the string

            if(username.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Please fill all the fields", Toast.LENGTH_SHORT).show()
                return@setOnclickListner
            }
            auth.createUserWiythEmailAndPassword(email,password).addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    val userId = auth.currentUser?.uid
                    //Gets the unique user Id firebase generates
                    valuserData = mapOf(
                        //userdatA: Amap (key-value pairs) to hold usernamename and email for database storage



                        "username" to username, "email" to email
                    )
                    userId?.let { uid ->
                        db.child("users").child(uid).setValue(userData)
                        //db.child("users").child(uid).setValue(userData):Adds users' usersname and email under a path like users/uid/username and users/uid/email
                        //users/uid
                        //username: "john
                        //Email:"john@gmail.com
                    }
                    Toast.makeText(this, "Signed up successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Signup Failed: ${e.message}", Toast.LENGTH_SHORT)
                            .show()
                    }
            }else{
                Toast.makeText(this,"Signup Failed",Toast.LENGTH_SHORT).show()
        }




            )



        }

    }
}

"users":{
    "0s63748484":{
        "usernam:" "john"
        "Email:" "john@gmail.com"
    }
}
