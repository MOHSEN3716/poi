    package com.example.poi

    import android.content.Intent
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.util.Log
    import android.widget.Button
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.example.poi.Adabter.NewsAdabter
    import com.example.poi.Adabter.UserListAdabter
    import com.example.poi.Database.DatabaseUser

    class

    MainActivity : AppCompatActivity() {
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
            var RecyclerView =findViewById<RecyclerView>(R.id.RecyclerViewUser)
            RecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
            var Useradabter = UserListAdabter()
            var Database =DatabaseUser(this)
            RecyclerView.adapter = Useradabter
            val list = Database.GetAldata()
            Log.d("tegf","${list}")
            Useradabter.loadedState(list)


        }
    }