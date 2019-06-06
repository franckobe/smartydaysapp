package com.ynovaix.smartydays.model

import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.delete

class TaskDb(private val dbHelper: TaskDbHelper) {

    fun getAll() = dbHelper.use {
        select(
            TaskTable.NAME,
            TaskTable.ID,
            TaskTable.LABEL,
            TaskTable.DONE
        ).parseList(classParser<Task>())
    }

    fun save(task: Task) = dbHelper.use {
        insert(
            TaskTable.NAME,
            TaskTable.LABEL to task.label,
            TaskTable.DONE to task.done
        )
    }

    fun delete(task: Task) = dbHelper.use {
        delete(
            TaskTable.NAME,
            "${TaskTable.ID} = ${task.id}"
        )
    }

}