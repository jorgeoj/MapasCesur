package com.example.examenkotlintrimestre2.database

import android.os.Build.VERSION
import android.provider.BaseColumns

class CesurContract {
    companion object {
        const val NOMBRE_DB = "cesures_del_mundo"
        const val  VERSION = 1
        class Entrada : BaseColumns {
            companion object {
                const val NOMBRE_TABLA = "cesures"
                const val COLUMNA_NOMBRE = "nombre"
                const val COLUMNA_CALLE = "calle"
                const val COLUMNA_IMAGEN = "imagen"
                const val COLUMNA_LATITUD = "latitud"
                const val COLUMNA_LONGITUD = "longitud"
            }
        }
    }
}