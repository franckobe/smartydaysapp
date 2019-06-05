package com.ynovaix.smartydays.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class TaskDbHelper(ctx: Context?) : ManagedSQLiteOpenHelper(ctx!!, DB_NAME, null, DB_VERSION) {
    companion object {
        const val DB_NAME = "task.db"
        const val DB_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
            TaskTable.NAME,
            true,
            TaskTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            TaskTable.LABEL to TEXT,
            TaskTable.DONE to INTEGER
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.dropTable(TaskTable.NAME, true)
        onCreate(db)
    }
}