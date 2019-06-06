package com.ynovaix.smartydays.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ynovaix.smartydays.R
import com.ynovaix.smartydays.model.*
import kotlinx.android.synthetic.main.activity_todo.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CreateTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)
    }

}
