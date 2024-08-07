//package com.example.poi.Adabter
//
//import android.content.Context
//import android.view.View
//import android.widget.TextView
//import com.example.poi.Database.ModelUser
//import com.example.poi.Model.Article
//import com.example.poi.R
//import io.github.farshidroohi.AdapterRecyclerView
//
//class UserListAdabter: AdapterRecyclerView<ModelUser>(R.layout.item_listuser,0,0,0) {
//    override fun onBindView(
//        viewHolder: ItemViewHolder,
//        position: Int,
//        context: Context,
//        element: ModelUser?
//    ) {
//        var View = viewHolder.itemView
//        var name = View.findViewById<TextView>(R.id.textView2)
//        name.text=element?.name
//    }
//}
