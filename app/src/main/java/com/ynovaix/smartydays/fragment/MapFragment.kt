package com.ynovaix.smartydays.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mapbox.mapboxsdk.Mapbox
import com.ynovaix.smartydays.R
import kotlinx.android.synthetic.main.fragment_map.*

class MapFragment : Fragment() {

    private lateinit var mapFragment: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mapFragment = inflater.inflate(R.layout.fragment_map, container, false)
        return mapFragment
    }

    override fun toString(): String {
        return "map_fragment"
    }



}
