package com.ynovaix.smartydays.activity

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mapbox.geojson.Feature
import com.mapbox.geojson.Point
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.style.layers.PropertyFactory
import com.mapbox.mapboxsdk.style.layers.SymbolLayer
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource
import com.ynovaix.smartydays.R
import kotlinx.android.synthetic.main.fragment_map.*

class MapActivity : AppCompatActivity() {

    private var mapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(this, getString(R.string.access_token))
        setContentView(R.layout.activity_main)
        mapView = mapViewLayout
        mapView!!.onCreate(savedInstanceState)
        mapView!!.getMapAsync { mapboxMap ->
            mapboxMap.setStyle(Style.LIGHT) { style ->
                // Add the marker image to map
                style.addImage(
                    "marker-icon-id",
                    BitmapFactory.decodeResource(
                        this@MapActivity.resources, R.drawable.mapbox_marker_icon_default
                    )
                )

                val geoJsonSource = GeoJsonSource(
                    "source-id", Feature.fromGeometry(
                        Point.fromLngLat(-87.679, 41.885)
                    )
                )
                style.addSource(geoJsonSource)

                val symbolLayer = SymbolLayer("layer-id", "source-id")
                symbolLayer.withProperties(
                    PropertyFactory.iconImage("marker-icon-id")
                )
                style.addLayer(symbolLayer)
            }
        }
    }

    // Add the mapView's own lifecycle methods to the activity's lifecycle methods
    public override fun onStart() {
        super.onStart()
        mapView!!.onStart()
    }

    public override fun onResume() {
        super.onResume()
        mapView!!.onResume()
    }

    public override fun onPause() {
        super.onPause()
        mapView!!.onPause()
    }

    public override fun onStop() {
        super.onStop()
        mapView!!.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView!!.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView!!.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView!!.onSaveInstanceState(outState)
    }
}