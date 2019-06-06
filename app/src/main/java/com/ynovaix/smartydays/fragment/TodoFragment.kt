package com.ynovaix.smartydays.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ynovaix.smartydays.R
import com.ynovaix.smartydays.activity.TodoActivity
import kotlinx.android.synthetic.main.fragment_item5.view.*
import org.jetbrains.anko.*

class TodoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_item5, container, false)
        view.button.setOnClickListener {
            context?.startActivity<TodoActivity>()
        }
        // Inflate the layout for this fragment
        return view
    }

    override fun toString(): String {
        return "item5_fragment"
    }

}