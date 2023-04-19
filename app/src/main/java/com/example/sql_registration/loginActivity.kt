package com.example.sql_registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class loginActivity : AppCompatActivity() {

    private lateinit var email_login:EditText
    private lateinit var password_login:EditText
    private lateinit var _loginbtn:Button
    private lateinit var _createaccount:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email_login = findViewById(R.id.edttextemail)
        password_login = findViewById(R.id.edttextpass)
        _loginbtn = findViewById(R.id.button3)
        _createaccount = findViewById(R.id.button4)

        _loginbtn.setOnClickListener() {
            var useremail = email_login.getText().toString()
            var userpass = password_login.getText().toString()

            if (useremail.isEmpty() || userpass.isEmpty()){

                Toast.makeText(this, "Cannot Submit empty field", Toast.LENGTH_SHORT).show()

            }

            loginUser(useremail, userpass);




        }

        _createaccount.setOnClickListener {

            Toast.makeText(this, "You have no account", Toast.LENGTH_SHORT).show()
            var gotomain = Intent(this, MainActivity::class.java)
            startActivity(gotomain)
        }
    }
}