package com.ynovaix.smartydays.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ynovaix.smartydays.R

class Item4Fragment : Fragment() {

    private lateinit var myView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        myView = inflater.inflate(R.layout.fragment_item4, container, false)

        // Inflate the layout for this fragment
        return myView
    }

    override fun toString(): String {
        return "item4_fragment"
    }

}