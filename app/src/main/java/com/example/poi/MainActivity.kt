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
    import com.example.poi.Database.ModelUser
    import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
    import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
    import com.patrykandpatrick.vico.compose.chart.Chart
    import com.patrykandpatrick.vico.compose.chart.line.lineChart
    import com.patrykandpatrick.vico.core.entry.entryModelOf
    import com.patrykandpatrick.vico.views.chart.ChartView

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
            val chartEntryModel = entryModelOf(40f, 52f, 88f, 45f)
            var ChartView= findViewById<ChartView>(R.id.chart_view)
            ChartView.setModel(chartEntryModel)




        }
    }