package com.example.poi.Adabter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.poi.R
import com.example.poi.model.Article
import com.example.poi.model.News
import io.github.farshidroohi.AdapterRecyclerView

class NewsAdabter:AdapterRecyclerView<Article>(R.layout.item_news,0,0,0) {
    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: Article?
    ) {
        var View = viewHolder.itemView
        var img = View.findViewById<ImageView>(R.id.imgNewsThumb)
        Glide.with(context).load(element?.urlToImage).into(img)
        var txtTitle = View.findViewById<TextView>(R.id.txtTitlecripto)
        txtTitle.text = element?.title
    }
}