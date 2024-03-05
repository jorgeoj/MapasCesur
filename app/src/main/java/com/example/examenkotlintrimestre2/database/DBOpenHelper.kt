package com.example.examenkotlintrimestre2.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.examenkotlintrimestre2.adapter.CesurProvider

class DBOpenHelper private constructor(context: Context?):
    SQLiteOpenHelper(context, CesurContract.NOMBRE_DB, null, CesurContract.VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        try {
            db?.execSQL(
                "CREATE TABLE ${CesurContract.Companion.Entrada.NOMBRE_TABLA}" +
                        "(${CesurContract.Companion.Entrada.COLUMNA_NOMBRE} NVARCHAR(50) NOT NULL" +
                        ",${CesurContract.Companion.Entrada.COLUMNA_CALLE} NVARCHAR(50) NOT NULL" +
                        ",${CesurContract.Companion.Entrada.COLUMNA_IMAGEN} int NOT NULL" +
                        ",${CesurContract.Companion.Entrada.COLUMNA_LATITUD} double NOT NULL" +
                        ",${CesurContract.Companion.Entrada.COLUMNA_LONGITUD} double NOT NULL);"
            )

            //Inserto los datos en la tabla
            inicializarBBDD(db)
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    private fun inicializarBBDD(db: SQLiteDatabase?) {
        val lista = CesurProvider.lista // Accedemos a la lista de PaisProvider y la metemos en esta vble.
        for (centro in lista) {
            db?.execSQL(
                ("INSERT INTO ${CesurContract.Companion.Entrada.NOMBRE_TABLA}(" +
                        "${CesurContract.Companion.Entrada.COLUMNA_NOMBRE}," +
                        "${CesurContract.Companion.Entrada.COLUMNA_CALLE}," +
                        "${CesurContract.Companion.Entrada.COLUMNA_IMAGEN}," +
                        "${CesurContract.Companion.Entrada.COLUMNA_LATITUD}," +
                        "${CesurContract.Companion.Entrada.COLUMNA_LONGITUD})" +

                        " VALUES ('${centro.nombreCentro}', '${centro.calle}', ${centro.imagenCentro}," +
                        "${centro.latitud}, ${centro.longitud});")
            )
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${CesurContract.Companion.Entrada.NOMBRE_TABLA};")
        onCreate(db)
    }

    companion object {
        // Variable estática para almacenar la única instancia de DBOpenHelper
        private var dbOpen: DBOpenHelper? = null

        // Función para obtener la instancia única de DBOpenHelper
        fun getInstance(context: Context?): DBOpenHelper? {
            // Verifica si la instancia ya ha sido creada
            if (dbOpen == null) {
                // Si no existe, crea una nueva instancia pasando el contexto
                dbOpen = DBOpenHelper(context)
            }
            // Devuelve la instancia única de DBOpenHelper
            return dbOpen
        }
    }
}