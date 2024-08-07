package com.example.poi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.poi.Database.Databaseprofessor
import com.example.poi.Database.Modelprofessor

class ActivityLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btnaddUser = findViewById<Button>(R.id.btnaddplace)

        val EdtName=findViewById<EditText>(R.id.edtName)
        val edtLastName=findViewById<EditText>(R.id.edtlastname)
        val edtPassword=findViewById<EditText>(R.id.edtcuorse)

        btnaddUser.setOnClickListener{

            val Name = EdtName.text.toString()
            val edtLastName = edtLastName.text.toString()
            val edtPassword=edtPassword.text.toString()
            val Modelprofessor= Modelprofessor(
                Name,
                edtLastName,
                edtPassword
            )
            val Database= Databaseprofessor(this)
            Database.addprofessor(Modelprofessor)
            Toast.makeText(this, "شد.", Toast.LENGTH_SHORT).show()
        }

    }
}