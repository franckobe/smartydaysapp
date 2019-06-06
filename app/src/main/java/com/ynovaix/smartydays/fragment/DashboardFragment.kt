package com.ynovaix.smartydays.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ynovaix.smartydays.R

class DashboardFragment : Fragment() {

    private lateinit var mapFragment: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mapFragment = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return mapFragment
    }

    override fun toString(): String {
        return "dashboard_fragment"
    }



}
