package com.example.poi.Adabter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.poi.R
import com.example.poi.model.Coins
import io.github.farshidroohi.AdapterRecyclerView

class CoinAdabter: AdapterRecyclerView<Coins>(R.layout.item_coin,0,0,0) {
    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: Coins?
    ) {
        var View = viewHolder.itemView
        var imgCoins = View.findViewById<ImageView>(R.id.imgCoinThumbail)
        Glide.with(context).load(element?.image).circleCrop().into(imgCoins)
        var txtCoinName = View.findViewById<TextView>(R.id.txtCoinName)
        txtCoinName.text = element?.name
        var txtSymbolName = View.findViewById<TextView>(R.id.txtSymbolName)
        txtSymbolName.text = element?.symbol
        var txtprice = View.findViewById<TextView>(R.id.txtprice)
        txtprice.text = "$${element?.current_price.toString()}"

    }


}