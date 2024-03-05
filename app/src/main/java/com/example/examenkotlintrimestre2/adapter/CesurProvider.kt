package com.example.examenkotlintrimestre2.adapter

import com.example.examenkotlintrimestre2.Cesur
import com.example.examenkotlintrimestre2.R

class CesurProvider {
    companion object{
        val lista = mutableListOf<Cesur>(
            Cesur(
                "Málaga Este",
                "Plaza Virgen de la Milagrosa, 11",
                "Málaga",
                R.drawable.mlgeste,
                36.71949371362025,
                -4.365499019622804
            ),
            Cesur(
                "Málaga PTA",
                "C/ Severo Ochoa nº 27 - 29",
                "Málaga",
                R.drawable.pta,
                36.73630863739562,
                -4.5574862028091525
            ),
            Cesur(
                "Málaga Teatinos",
                "Blvr. Louis Pasteur, 7",
                "Málaga",
                R.drawable.teatinos,
                36.71812977471156,
                -4.4611284899614665
            ),
            Cesur(
                "Sevilla CAFD",
                "Avda. Dr. Miguel Rios Sarmiento,3",
                "Sevilla",
                R.drawable.cafd,
                37.3971062729853,
                -5.930517860459692
            ),
            Cesur(
                "Sevilla Cartuja",
                "C/ Arquímedes, 2",
                "Sevilla",
                R.drawable.cartuja,
                37.41110891763523,
                -6.003516930337724
            ),
            Cesur(
                "Sevilla Estadio",
                "Isla de la Cartuja, Sector Norte",
                "Sevilla",
                R.drawable.estadio,
                37.41644811195961,
                -6.005719960459087
            ),
            Cesur(
                "Madrid Plaza Elíptica",
                "Calle Santa Lucrecia, 11",
                "Madrid",
                R.drawable.eliptica,
                40.39021165602301,
                -3.7186542409219827
            ),
            Cesur(
                "Madrid Ciudad Lineal",
                "C/ Albarracín, 27",
                "Madrid",
                R.drawable.lineal,
                40.43586487789104,
                -3.6325818625096
            ),
            Cesur(
                "Madrid Chamartín",
                "C/ Luis Cabrera, 63",
                "Madrid",
                R.drawable.chamartin,
                40.44462360293975,
                -3.672388605035227
            )
        )
    }
}