package com.example.poi.Adabter

import android.content.Context
import android.text.util.Linkify
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.poi.R
import com.example.poi.Model.Article
import io.github.farshidroohi.AdapterRecyclerView

class NewsAdabter:AdapterRecyclerView<Article>(R.layout.item_news,0,0,0) {

    private fun onTextViewClicked(txtTitle: TextView) {
        txtTitle.maxLines = Int.MAX_VALUE
        txtTitle.ellipsize = null
    }
    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: Article?
    ) {
        var View = viewHolder.itemView
        var img = View.findViewById<ImageView>(R.id.imageView2)
        Glide.with(context).load(element?.urlToImage).into(img)
        var txtTitle = View.findViewById<TextView>(R.id.txtdescription)
        txtTitle.text= element?.description
        var txtUrl=View.findViewById<TextView>(R.id.txturl)
        txtUrl.text=element?.url
        txtUrl.autoLinkMask = Linkify.WEB_URLS
        var txtID = View.findViewById<TextView>(R.id.txtid)
        txtID.text=element?.author

        txtTitle.setOnClickListener {
            onTextViewClicked(txtTitle)
        }

    }
}