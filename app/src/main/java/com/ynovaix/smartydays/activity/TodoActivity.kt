package com.ynovaix.smartydays.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ynovaix.smartydays.R
import com.ynovaix.smartydays.model.Task
import com.ynovaix.smartydays.model.TaskDb
import com.ynovaix.smartydays.model.TaskDbHelper
import kotlinx.android.synthetic.main.activity_todo.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TodoActivity : AppCompatActivity() {

    private val taskDb by lazy { TaskDb(TaskDbHelper(applicationContext)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        saveButton.setOnClickListener {
            createTask()
        }

    }
    private fun createTask(){
        doAsync {
            taskDb.save(Task(0, labelText.text.toString(), 0))
            uiThread {
                finish()
            }
        }
    }
}
