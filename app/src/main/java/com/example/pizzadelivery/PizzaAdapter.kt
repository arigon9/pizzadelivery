package com.example.pizzadelivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Pizza(val name:String)
class PizzaAdapter(
    private val pizzaList: List<Pizza>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {


    interface OnItemClickListener {
        fun onItemClick(pizza: Pizza)
    }


    class PizzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(android.R.id.text1)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return PizzaViewHolder(view)
    }


    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizza = pizzaList[position]
        holder.textView.text = pizza.name


        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(pizza)
        }
    }


    override fun getItemCount(): Int {
        return pizzaList.size
    }
}