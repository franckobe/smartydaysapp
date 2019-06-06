package com.ynovaix.smartydays.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ynovaix.smartydays.R
import kotlinx.android.synthetic.main.activity_todo.*
import org.jetbrains.anko.startActivity

class TodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

    }
    private fun updateTask(){

    }
}
