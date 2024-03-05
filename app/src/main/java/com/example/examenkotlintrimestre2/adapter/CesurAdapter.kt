package com.example.examenkotlintrimestre2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenkotlintrimestre2.Cesur
import com.example.examenkotlintrimestre2.R

class CesurAdapter(private var cesurList:List<Cesur>, private val onClickListener: (Cesur) -> Unit): RecyclerView.Adapter<CesurViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CesurViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CesurViewHolder(layoutInflater.inflate(R.layout.item_cesur, parent, false))
    }

    override fun getItemCount(): Int = cesurList.size

    override fun onBindViewHolder(holder: CesurViewHolder, position: Int) {
        val item = cesurList[position]
        holder.render(item, onClickListener)
    }
}