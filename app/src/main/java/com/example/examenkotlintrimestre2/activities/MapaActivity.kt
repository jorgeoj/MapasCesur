package com.example.examenkotlintrimestre2.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examenkotlintrimestre2.R
import com.example.examenkotlintrimestre2.databinding.ActivityMapaBinding
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.ItemizedIconOverlay
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus
import org.osmdroid.views.overlay.OverlayItem

class MapaActivity : AppCompatActivity() {

    private lateinit var map: MapView
    private lateinit var binding: ActivityMapaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Configuration.getInstance()
            .load(applicationContext, this.getPreferences(Context.MODE_PRIVATE))
        binding = ActivityMapaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cesurLatitud = intent.getDoubleExtra("latitud", 0.0)
        val  cesurLongitud = intent.getDoubleExtra("longitud", 0.0)

        map = binding.map
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)
        val mapController = map.controller
        mapController.setZoom(9.5)


        val items: ArrayList<OverlayItem> = ArrayList()
        items.add(OverlayItem("Cesur Málaga Este", "Plaza Virgen de la Milagrosa, 11", "Málaga",
            GeoPoint(36.71949371362025, -4.365499019622804)))
        items.add(OverlayItem("Cesur Málaga PTA", "C/ Severo Ochoa nº 27 - 29", "Málaga",
            GeoPoint(36.73630863739562, -4.5574862028091525)))
        items.add(OverlayItem("Cesur Málaga Teatinos", "Blvr. Louis Pasteur, 7", "Málaga",
            GeoPoint(36.71812977471156, -4.4611284899614665)))
        items.add(OverlayItem("Cesur Sevilla CAFD", "Avda. Dr. Miguel Rios Sarmiento,3", "Sevilla",
            GeoPoint(37.3971062729853, -5.930517860459692)))
        items.add(OverlayItem("Cesur Sevilla Cartuja", "C/ Arquímedes, 2", "Sevilla",
            GeoPoint(37.41110891763523, -6.003516930337724)))
        items.add(OverlayItem("Cesur Sevilla Estadio", "Isla de la Cartuja, Sector Norte", "Sevilla",
            GeoPoint(37.41644811195961, -6.005719960459087)))
        items.add(OverlayItem("Cesur Madrid Plaza Elíptica", "Calle Santa Lucrecia, 11", "Madrid",
            GeoPoint(40.39021165602301, -3.7186542409219827)))
        items.add(OverlayItem("Cesur Madrid Ciudad Lineal", "C/ Albarracín, 27", "Madrid",
            GeoPoint(40.43586487789104, -3.6325818625096)))
        items.add(OverlayItem("Cesur Madrid Chamartín", "C/ Luis Cabrera, 63", "Madrid",
            GeoPoint(40.44462360293975, -3.672388605035227)))

        val mOverlay: ItemizedOverlayWithFocus<OverlayItem> =
            ItemizedOverlayWithFocus(
                items,
                object : ItemizedIconOverlay.OnItemGestureListener<OverlayItem?>{
                    override fun onItemSingleTapUp(index: Int, item: OverlayItem?): Boolean {
                        return true
                    }

                    override fun onItemLongPress(index: Int, item: OverlayItem?): Boolean {
                        return false
                    }
                }, applicationContext
            )
        mOverlay.setFocusItemsOnTap(true)
        map.getOverlays().add(mOverlay)
        mapController.setCenter(GeoPoint(cesurLatitud, cesurLongitud))
    }

    public override fun onResume() {
        super.onResume()
        map.onResume()
    }

    public override fun onPause() {
        super.onPause()
        map.onPause()
    }
}