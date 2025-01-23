package com.example.poi.morActivity

import AddCourseViewModel
import Course
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.poi.R

class ActivityAddAatabase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adddatabes)
        val btnaddUser = findViewById<Button>(R.id.btnaddplace)

        val viewModel = ViewModelProvider(this)[AddCourseViewModel::class.java]
        btnaddUser.setOnClickListener{
            val newCourse = Course(0, "mon", 1)
            viewModel.insertCourse(newCourse)

        }


    }
}

