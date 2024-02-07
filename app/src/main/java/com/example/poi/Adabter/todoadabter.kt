package com.example.poi.Adabter

import android.content.Context
import android.widget.TextView
import com.example.poi.R
import com.example.poi.model.todos
import io.github.farshidroohi.AdapterRecyclerView

class todoadabter:AdapterRecyclerView<todos>(R.layout.todopost,0,0,0){
    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: todos?
    ) {
        var view=viewHolder.itemView
        var txtuserId=view.findViewById<TextView>(R.id.textView)
        txtuserId.text= element?.title


    }
}