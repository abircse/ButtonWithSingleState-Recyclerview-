package com.coxtunes.buttonStateRecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.coxtunes.buttonStateRecyclerview.RecyclerAdapter.MyViewHolder

class RecyclerAdapter(private val context: Context, private val productCategoryList: MutableList<ProductCategory>) : RecyclerView.Adapter<MyViewHolder>() {

    // if you put 0 here it will be selected first item
    // if you put -1 here it will not select any item initially
    var selectedItem: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_items, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.tag = productCategoryList[position]
        holder.name.text = productCategoryList[position].name

        // Condition for unselected item background color changed
        holder.itembackground.background = ContextCompat.getDrawable(context, R.drawable.button_unselect_backgroud)
        holder.name.setTextColor(context.resources.getColor(R.color.fontcolor))


        // Condition for selected item background color changed
        if (selectedItem == position) {
            holder.itembackground.background = ContextCompat.getDrawable(context, R.drawable.button_selected_backgroud)
            holder.name.setTextColor(context.resources.getColor(R.color.white))
        }

        // item click
        holder.itemView.setOnClickListener {
            val previousItem = selectedItem
            selectedItem = position
            notifyItemChanged(previousItem)
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return productCategoryList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById<View>(R.id.tv_pets) as TextView
        var itembackground: ConstraintLayout =
            view.findViewById<View>(R.id.itemlayout) as ConstraintLayout
    }
}