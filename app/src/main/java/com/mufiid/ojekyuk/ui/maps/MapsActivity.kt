package com.mufiid.ojekyuk.ui.maps

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import com.mufiid.ojekyuk.R
import com.mufiid.ojekyuk.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private var binding: ActivityMapsBinding? = null
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val mapFragment = SupportMapFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.map, mapFragment)
            .commit()
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isZoomControlsEnabled = true

        val routes = Sources.getResultRoutes()
        val coordinates = routes.data?.route.orEmpty()
            .map {
                LatLng(it?.latitude ?: 0.0, it?.longitude ?: 0.0)
            }

        val point1 = coordinates.firstOrNull()
        if (point1 != null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point1, 14f))
        }

        val polyline = PolylineOptions()
            .addAll(coordinates)
            .width(10f)
            .color(Color.BLUE)
        mMap.addPolyline(polyline)
    }
}