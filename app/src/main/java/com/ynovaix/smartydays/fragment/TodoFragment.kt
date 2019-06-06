package com.ynovaix.smartydays.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.ynovaix.smartydays.R
import com.ynovaix.smartydays.activity.TodoActivity
import com.ynovaix.smartydays.model.Task
import com.ynovaix.smartydays.model.TaskDb
import com.ynovaix.smartydays.model.TaskDbHelper
import com.ynovaix.smartydays.util.EmptyAdapter
import com.ynovaix.smartydays.util.TaskAdapter
import kotlinx.android.synthetic.main.fragment_item5.view.*
import org.jetbrains.anko.*

class TodoFragment : Fragment(), AnkoLogger {
    private val taskDb by lazy { TaskDb(TaskDbHelper(context?.applicationContext)) }

    private var list = listOf<Task>()
    private lateinit var todoView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        todoView = inflater.inflate(R.layout.fragment_item5, container, false)
        todoView.button.setOnClickListener {
            context?.startActivity<TodoActivity>()
        }
        todoView.task_list.layoutManager = LinearLayoutManager(context?.applicationContext)
        todoView.task_list.adapter = EmptyAdapter()

        updateRecyclerView()
        // Inflate the layout for this fragment
        return todoView
    }

    private fun updateRecyclerView() {
        doAsync {
            list = taskDb.getAll()
            info { list.size }
            uiThread {
                todoView.task_list.adapter = TaskAdapter(list, object : TaskAdapter.OnItemClickListener {
                    override fun onItemClick(task: Task) {

                    }

                }, object : TaskAdapter.OnSwitchChangeListener {
                    override fun onItemChecked(task: Task) {
                        taskDb.update(task)
                    }

                })
            }
        }
    }

    override fun toString(): String {
        return "item5_fragment"
    }

}