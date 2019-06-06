package com.ynovaix.smartydays.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ynovaix.smartydays.R
import com.ynovaix.smartydays.model.Task
import kotlinx.android.synthetic.main.list_item_task.view.*


class TaskAdapter(private var items: List<Task>, private val switchListener: OnSwitchChangeListener): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTask(items[position], switchListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): ViewHolder {
        val lineView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_task, parent, false)
        return ViewHolder(lineView)
    }

    fun update(modelList:List<Task>){
        items = modelList
        notifyDataSetChanged()
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bindTask(task: Task, switchListener: OnSwitchChangeListener) {
            itemView.list_item_task_label.text = task.label
            itemView.list_item_task_done.isChecked = task.done == 1
            itemView.list_item_task_done.setOnCheckedChangeListener { buttonView, isChecked ->
                switchListener.onItemChecked(task, isChecked)
            }
        }
    }

    interface OnSwitchChangeListener
    {
        fun onItemChecked(task: Task, checked: Boolean)
    }

}