package com.example.poi.Adabter

import android.content.Context
import android.view.View
import android.widget.TextView
import com.example.poi.R
import com.example.poi.model.Article
import io.github.farshidroohi.AdapterRecyclerView

class NewsCountryAdabter: AdapterRecyclerView<Article>(R.layout.linear_news_item,0,0,0) {
    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: Article?
    ) {
        var View = viewHolder.itemView

        var txt = View.findViewById<TextView>(R.id.TxtNewsCountry)
        txt.text=element?.title
    }


}