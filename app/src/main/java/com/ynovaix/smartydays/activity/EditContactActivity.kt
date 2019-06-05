package com.ynovaix.smartydays.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ynovaix.smartydays.R
import com.ynovaix.smartydays.model.Contact
import com.ynovaix.smartydays.model.ContactDb
import com.ynovaix.smartydays.model.ContactDbHelper
import kotlinx.android.synthetic.main.activity_edit_contact.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EditContactActivity : AppCompatActivity() {

    private var selectedId: Int = 0
    private lateinit var selectedContact: Contact

    private val contactDb by lazy { ContactDb(ContactDbHelper(applicationContext)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)

        selectedId = intent?.extras?.getInt("selectedId") ?: 0
        setSelectedContact()

    }

    private fun setSelectedContact() {
        doAsync {
            selectedContact = contactDb.getOneById(selectedId)
            uiThread {
                displaySelectedContact()
            }
        }
    }

    private fun displaySelectedContact() {
        editContactFirstname.setText(selectedContact.firstname)
        editContactLastname.setText(selectedContact.lastname)
        editContactEmail.setText(selectedContact.email)
        editContactAddress.setText(selectedContact.address)
    }

}
