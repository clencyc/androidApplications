package com.example.sql_registration

import android.annotation.SuppressLint
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var btncreate: Button
    private lateinit var nameedt: EditText
    private lateinit var name2edt: EditText
    private lateinit var emailtxt: EditText
    private lateinit var passwordtxt: EditText
    private lateinit var Loginbtn: Button
    private lateinit var db: SQLiteDatabase



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btncreate = findViewById(R.id.button)
        nameedt = findViewById(R.id.edtname1)
        name2edt = findViewById(R.id.edtname2)
        emailtxt = findViewById(R.id.edtemail)
        passwordtxt = findViewById(R.id.edtpassword)
        Loginbtn = findViewById(R.id.button2)

        db = openOrCreateDatabase("clencyDB", MODE_PRIVATE, null)
        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho VARCHAR, siri VARCHAR )")

        btncreate.setOnClickListener {
            //Receive data from the user
            val name = nameedt.text.toString()
            val name2 = name2edt.text.toString()
            val email = emailtxt.text.toString()
            val password = passwordtxt.text.toString()
            //Check if the user is trying to submit empty records
            if (name.isEmpty() || name2.isEmpty() || email.isEmpty() || password.isEmpty()) {
                //Use the display_message() to Display a message telling the user to fill all the inputs

                //toast a message to say cannot submit empty field
                Toast.makeText(this, "Cannot Submit empty field", Toast.LENGTH_SHORT).show()



            } else {
                //Proceed to save your data into the db
                db.execSQL("INSERT INTO users VALUES('"+name+"', '"+name2+"', '"+email+"', '"+password+"')")


                //Toast a success message
                Toast.makeText(this, "User Created succesfully", Toast.LENGTH_SHORT).show()

            }
        }

        Loginbtn.setOnClickListener {
            var gotologin = Intent(this, loginActivity::class.java)
            startActivity(gotologin)
        }


    }
}
