package com.example.poi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.poi.Database.DatabaseUser
import com.example.poi.Database.ModelUser

class ActivityLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btnaddUser = findViewById<Button>(R.id.btnaddplace)

        val EdtName=findViewById<EditText>(R.id.edtName)
        val edtLastName=findViewById<EditText>(R.id.edtLastName)
        val edtyear=findViewById<EditText>(R.id.edtyear)
        val edtEmail=findViewById<EditText>(R.id.edtEmail)
        val edtPassword=findViewById<EditText>(R.id.edtPassword)

        btnaddUser.setOnClickListener{

            val Name = EdtName.text.toString()
            val edtLastName = edtLastName.text.toString()
            val edtyear = edtyear.text.toString().toInt()
            val edtEmail = edtEmail.text.toString()
            val edtPassword=edtPassword.text.toString().toInt()
            val ModelUser= ModelUser(
                Name,
                edtLastName,
                edtEmail,
                edtPassword,
                edtyear
            )
            val Database=DatabaseUser(this)
            Database.addUser(ModelUser)
            Toast.makeText(this, "شد.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }




    }
}