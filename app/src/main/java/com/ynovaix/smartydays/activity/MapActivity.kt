package com.ynovaix.smartydays.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mapbox.mapboxsdk.Mapbox
import com.ynovaix.smartydays.R
import kotlinx.android.synthetic.main.fragment_map.*

class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapbox.onCreate(savedInstanceState)

        Mapbox.getInstance(
            this,
            "pk.eyJ1IjoidGhvbWFzYW5nZWxpbmkiLCJhIjoiY2p3anBmcW1sMG02cTQwbjYyOG5mbnN6eCJ9.Sd6HjWyahzr_1ennL_k_0A"
        )
        setContentView(R.layout.fragment_map)
    }

    @SuppressWarnings("MissingPermission")
    override fun onStart() {
        super.onStart()
        mapbox.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapbox.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapbox.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapbox.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapbox.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapbox.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (outState != null) {
            mapbox.onSaveInstanceState(outState)
        }
    }
}
