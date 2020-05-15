package com.vokasi.tambalbanuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_ban_kontak.*

class ban_dekat : AppCompatActivity() {

    lateinit var mapFragment : SupportMapFragment
    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ban_dekat)

        kembali.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
            finish()
        }

        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it

            val location1 = LatLng(-6.740343,111.668981)
            googleMap.addMarker(MarkerOptions().position(location1).title("Tambal Ban Bang Tony"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,15f))

            val location2 = LatLng(-6.727050,111.658188)
            googleMap.addMarker(MarkerOptions().position(location2).title("Tambal Ban Cototan"))
        })
    }
}
