package com.example.sql_registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class DashboardActivity : AppCompatActivity() {
    private lateinit var BTNOUT: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        BTNOUT = findViewById(R.id.btnout)

        BTNOUT.setOnClickListener {
            Toast.makeText(this, "Loggedout succesfully", Toast.LENGTH_SHORT).show()
        }
        var gotologout = Intent(this, DashboardActivity::class.java)
        startActivity(gotologout)




    }
}