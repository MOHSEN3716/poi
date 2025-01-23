    package com.example.poi.morActivity

    import android.content.Intent
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.widget.Button
    import com.example.poi.R

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            var btnNews = findViewById<Button>(R.id.btnNews)
            var btnCoinlist = findViewById<Button>(R.id.btnCoinlist)

            btnCoinlist.setOnClickListener {
                val intent = Intent(this, ActivityCoinlist::class.java)
                startActivity(intent)
            }
            btnNews.setOnClickListener {
                val intent = Intent(this, ActivityCriptoNews::class.java)
                startActivity(intent)
            }



        }
    }