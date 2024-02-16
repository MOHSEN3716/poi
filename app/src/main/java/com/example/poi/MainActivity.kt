    package com.example.poi

    import android.content.Intent
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.util.Log
    import android.widget.Button
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

            var btnNews = findViewById<Button>(R.id.btnNews)
            var btnCoinlist = findViewById<Button>(R.id.btnCoinlist)

            btnCoinlist.setOnClickListener{
                val intent = Intent(this, ActivityCoinlist::class.java)
                startActivity(intent)
            }
            btnNews.setOnClickListener{
                val intent = Intent(this, ActivityCriptoNews::class.java)
                startActivity(intent)
            }

        }
    }