package com.ynovaix.smartydays.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class ContactDbHelper(ctx: Context?) : ManagedSQLiteOpenHelper(ctx!!, DB_NAME, null, DB_VERSION) {

    companion object {
        const val DB_NAME = "contact.db"
        const val DB_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
            ContactTable.NAME,
            true,
            ContactTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            ContactTable.FIRSTNAME to TEXT,
            ContactTable.LASTNAME to TEXT,
            ContactTable.EMAIL to TEXT,
            ContactTable.ADDRESS to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.dropTable(ContactTable.NAME, true)
        onCreate(db)
    }

}