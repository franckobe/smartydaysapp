package com.ynovaix.smartydays.model

import org.jetbrains.anko.db.*

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

    fun getAllBySearch(str: String) = dbHelper.use {
        select(
            ContactTable.NAME,
            ContactTable.ID,
            ContactTable.FIRSTNAME,
            ContactTable.LASTNAME,
            ContactTable.EMAIL,
            ContactTable.ADDRESS
        )
            .whereArgs("${ContactTable.FIRSTNAME} LIKE '%$str%' OR ${ContactTable.LASTNAME} LIKE '%$str%'")
            .parseList(classParser<Contact>())
    }

    fun getOneById(id: Int) = dbHelper.use {
        select(
            ContactTable.NAME,
            ContactTable.ID,
            ContactTable.FIRSTNAME,
            ContactTable.LASTNAME,
            ContactTable.EMAIL,
            ContactTable.ADDRESS
        ).whereArgs("${ContactTable.ID} = $id").parseList(classParser<Contact>()).first()
    }

    fun update(contact: Contact) = dbHelper.use {
        update(
            ContactTable.NAME,
            ContactTable.FIRSTNAME to contact.firstname,
            ContactTable.LASTNAME to contact.lastname,
            ContactTable.EMAIL to contact.email,
            ContactTable.ADDRESS to contact.address
        )
            .whereArgs("${ContactTable.ID} = ${contact.id}")
            .exec()
    }

}