package com.ynovaix.smartydays.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ynovaix.smartydays.R
import org.jetbrains.anko.AnkoLogger

class EmptyAdapter: RecyclerView.Adapter<EmptyAdapter.ViewHolder>(), AnkoLogger {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): ViewHolder {
        val lineView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_contact, parent, false)
        return ViewHolder(lineView)
    }

    override fun getItemCount(): Int {
        return 0
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        //
    }

}