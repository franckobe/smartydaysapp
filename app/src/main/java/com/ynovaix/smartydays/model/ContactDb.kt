package com.ynovaix.smartydays.model

import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.delete

class ContactDb(private val dbHelper: ContactDbHelper) {

    fun getAll() = dbHelper.use {
        select(
            ContactTable.NAME,
            ContactTable.ID,
            ContactTable.FIRSTNAME,
            ContactTable.LASTNAME,
            ContactTable.EMAIL,
            ContactTable.ADDRESS
        ).parseList(classParser<Contact>())
    }

    fun save(contact: Contact) = dbHelper.use {
        insert(
            ContactTable.NAME,
            ContactTable.FIRSTNAME to contact.firstname,
            ContactTable.LASTNAME to contact.lastname,
            ContactTable.FIRSTNAME to contact.firstname,
            ContactTable.EMAIL to contact.email,
            ContactTable.ADDRESS to contact.address
        )
    }

    fun delete(contact: Contact) = dbHelper.use {
        delete(
            ContactTable.NAME,
            "${ContactTable.ID} = ${contact.id}"
        )
    }

}