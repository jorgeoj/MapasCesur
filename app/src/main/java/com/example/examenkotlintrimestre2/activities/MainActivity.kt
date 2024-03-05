package com.example.examenkotlintrimestre2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenkotlintrimestre2.Cesur
import com.example.examenkotlintrimestre2.R
import com.example.examenkotlintrimestre2.adapter.CesurAdapter
import com.example.examenkotlintrimestre2.adapter.CesurProvider
import com.example.examenkotlintrimestre2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CesurAdapter
    private lateinit var lista: List<Cesur>
    private lateinit var intentLaunch: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Añadimos la toolbar personalizada
        setSupportActionBar(binding.toolbar)

        lista = mutableListOf()
        lista = CesurProvider.lista

        adapter = CesurAdapter(lista) {
                pais -> handleItemClick(pais, adapter)
        }

        binding.rvCesur.layoutManager = LinearLayoutManager(this)
        binding.rvCesur.adapter = adapter

        intentLaunch = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                //val posicion = result.data?.extras?.getInt("posicion", 0)
                //lista[posicion!!].nombreCentro = result.data?.extras?.getString("nuevoNombre").toString()
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun handleItemClick(cesur: Cesur, adapter: CesurAdapter) {
        val intent = Intent(this, MapaActivity::class.java)
        intent.putExtra("nombre", cesur.nombreCentro)
        intent.putExtra("calle", cesur.calle)
        intent.putExtra("ciudad", cesur.ciudad)
        intent.putExtra("latitud", cesur.latitud)
        intent.putExtra("longitud", cesur.longitud)
        intentLaunch.launch(intent)
    }
}