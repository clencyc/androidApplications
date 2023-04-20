package com.example.sql_registration

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
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
    lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email_login = findViewById(R.id.edttextemail)
        password_login = findViewById(R.id.edttextpass)
        _loginbtn = findViewById(R.id.button3)
        _createaccount = findViewById(R.id.button4)

        db = openOrCreateDatabase("clencyDB", MODE_PRIVATE, null)
        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho VARCHAR, siri VARCHAR )")


        _loginbtn.setOnClickListener() {
            //Write a logic to check if user exists in SQL

            var email = email_login.text.toString().trim()
            var password = password_login.text.toString().trim()

            //validate our fields
            if (email.isEmpty() || password.isEmpty()) {

                Toast.makeText(this, "Cannot Submit an empty field", Toast.LENGTH_SHORT).show()

                }else{
                val cursor = db.rawQuery("SELECT * FROM users WHERE kitambulisho=? AND siri=?", arrayOf(email, password))

                if (cursor != null && cursor.moveToFirst()) {
                    // user is authenticated, start a new activity
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid email or password, please try again", Toast.LENGTH_SHORT).show()
                    var login = Intent(this, DashboardActivity::class.java)
                    startActivity(login)
                }


                }





        }

        _createaccount.setOnClickListener {

            Toast.makeText(this, "You have no account", Toast.LENGTH_SHORT).show()
            var gotomain = Intent(this, MainActivity::class.java)
            startActivity(gotomain)
        }
    }
}