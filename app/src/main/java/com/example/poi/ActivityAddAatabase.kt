package com.example.poi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.poi.Database.Databaseprofessor
import com.example.poi.Database.Modelprofessor

class ActivityAddAatabase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adddatabes)
        val btnaddUser = findViewById<Button>(R.id.btnaddplace)

        val EdtName=findViewById<EditText>(R.id.edtName)
        val edtLastName=findViewById<EditText>(R.id.edtlastname)
        val edtcuorse=findViewById<EditText>(R.id.edtcuorse)

        btnaddUser.setOnClickListener{

            val Name = EdtName.text.toString()
            val edtLastName = edtLastName.text.toString()
            val edtPassword=edtcuorse.text.toString()
            val Modelprofessor= Modelprofessor(
                Name,
                edtLastName,
            )
            val Database= Databaseprofessor(this)
            Database.addProfessor(Modelprofessor)
            Toast.makeText(this, "شد.", Toast.LENGTH_SHORT).show()
        }

    }
}