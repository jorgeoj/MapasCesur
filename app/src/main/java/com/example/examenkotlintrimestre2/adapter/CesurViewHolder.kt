package com.example.examenkotlintrimestre2.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.examenkotlintrimestre2.Cesur
import com.example.examenkotlintrimestre2.databinding.ItemCesurBinding

class CesurViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemCesurBinding.bind(view)
    private lateinit var cesur: Cesur

    fun render(item: Cesur, onClickLister: (Cesur) -> Unit) {
        // Inicializamos cada elemento del xml
        binding.ivCentro.setImageResource(item.imagenCentro)
        binding.tvNombreCentro.text = item.nombreCentro
        binding.tvPosicionCentro.text = item.calle
        binding.tvCiudad.text = item.ciudad
        itemView.setOnClickListener {
            onClickLister(item)
        }
        cesur = item
    }
}