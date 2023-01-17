package com.example.underground.adaptervol2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.underground.R
import com.example.underground.datavol2.Dataforadapter
import com.google.android.material.imageview.ShapeableImageView

class Adapter(private val dataList : ArrayList<Dataforadapter>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private lateinit var nListener: SetOnItemClicker
    interface SetOnItemClicker{

        fun onItemClicker(position: Int)
    }
    fun SetOnItemClicker(listener: SetOnItemClicker){

        nListener = listener

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list2, parent, false)
        return Adapter.MyViewHolder(itemView, nListener)
    }

    override fun onBindViewHolder(holder: Adapter.MyViewHolder, position: Int) {

        val currentItem = dataList[position]
        holder.profile.setImageResource(currentItem.profile)
        holder.price.text = currentItem.price
        holder.description.text = currentItem.description
        holder.name.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class MyViewHolder(itemView : View, listener: SetOnItemClicker) : RecyclerView.ViewHolder(itemView){

        val profile: ShapeableImageView = itemView.findViewById(R.id.profile)
        val price: TextView = itemView.findViewById(R.id.price1)
        val description: TextView = itemView.findViewById(R.id.description)
        val name: TextView = itemView.findViewById(R.id.name)
        init {

            itemView.setOnClickListener {
                listener.onItemClicker(adapterPosition)
            }

        }

    }
}