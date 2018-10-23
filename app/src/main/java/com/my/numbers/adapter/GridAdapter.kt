package com.my.numbers.adapter

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my.numbers.R
import com.my.numbers.activity.MainActivity
import com.my.numbers.fragment.NumberFragment
import kotlinx.android.synthetic.main.grid_item.view.*

class GridAdapter(val numbers: IntArray, private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return numbers.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.number.text = numbers[position].toString()
        if (numbers[position] % 2 == 0) {
            holder.number.setTextColor(Color.RED)
        } else {
            holder.number.setTextColor(Color.BLUE)
        }

        holder.layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt(NumberFragment.KEY_NUMBER, numbers[position])
            bundle.putInt(NumberFragment.KEY_COLOR, holder.number.currentTextColor)
            (context as MainActivity).replaceFragment(NumberFragment(), bundle, true)
        }
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val number = view.textNumber!!
    val layout = view.layout!!
}