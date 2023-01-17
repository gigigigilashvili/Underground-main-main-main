package com.example.underground.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.underground.R
import com.example.underground.dataa.Data
import com.google.android.material.imageview.ShapeableImageView

class recyclerview(private val dataList : ArrayList<Data>) : RecyclerView.Adapter<recyclerview.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{

        fun onItemClick(position: Int)
    }

    fun onItemClickListener(listener: onItemClickListener){

        mListener = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list, parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = dataList[position]
        holder.imagetitle.setImageResource(currentItem.imagetitle)
        holder.heading.text = currentItem.heading
        holder.price.text = currentItem.price
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val imagetitle: ShapeableImageView = itemView.findViewById(R.id.imagetitle)
        val heading: TextView = itemView.findViewById(R.id.heading)
        val price: TextView = itemView.findViewById(R.id.price)

        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }

    }

}