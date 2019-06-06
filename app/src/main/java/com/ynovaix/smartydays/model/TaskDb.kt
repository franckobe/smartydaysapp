package com.ynovaix.smartydays.model

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.update
import org.jetbrains.anko.info

class TaskDb(private val dbHelper: TaskDbHelper): AnkoLogger {

    fun getAll() = dbHelper.use {
        select(
            TaskTable.NAME,
            TaskTable.ID,
            TaskTable.LABEL,
            TaskTable.DONE
        ).parseList(classParser<Task>())
    }

    fun save(task: Task) = dbHelper.use {
        val done = 0
        insert(
            TaskTable.NAME,
            TaskTable.LABEL to task.label,
            TaskTable.DONE to done
        )
    }

    fun delete(task: Task) = dbHelper.use {
        delete(
            TaskTable.NAME,
            "${TaskTable.ID} = ${task.id}"
        )
    }

    fun update(task: Task, done: Int) = dbHelper.use {
        update(
                TaskTable.NAME,
        TaskTable.DONE to done
        )
        .whereArgs("${TaskTable.ID} = ${task.id}")
        .exec()
    }

}