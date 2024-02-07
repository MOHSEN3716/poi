    package com.example.poi

    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.util.Log
    import android.widget.Toast
    import androidx.lifecycle.Observer
    import androidx.lifecycle.ViewModelProvider
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.example.poi.Adabter.todoadabter
    import com.example.poi.Viewmodel.mainviewmodel
    import com.example.poi.tenwork.Apiservise

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val recyclerview = findViewById<RecyclerView>(R.id.rectangles)
            val todoadabter = todoadabter()
            recyclerview.adapter = todoadabter
            recyclerview.layoutManager = LinearLayoutManager(this)
            var mainviewmodel = ViewModelProvider(this).get(mainviewmodel::class.java)
            mainviewmodel.gettodos()

            mainviewmodel.todosLiveData.observe(this, Observer {
                it.forEach {
                    todoadabter.loadingState()
                }
            })
        }
    }