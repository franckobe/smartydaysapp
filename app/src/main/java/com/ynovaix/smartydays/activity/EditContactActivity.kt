package com.ynovaix.smartydays.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ynovaix.smartydays.R
import com.ynovaix.smartydays.model.Contact
import com.ynovaix.smartydays.model.ContactDb
import com.ynovaix.smartydays.model.ContactDbHelper
import com.ynovaix.smartydays.util.ContactRequestCode
import kotlinx.android.synthetic.main.activity_edit_contact.*
import org.jetbrains.anko.contentView
import org.jetbrains.anko.design.snackbar
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

        btnEditContact.setOnClickListener {
            updateContact()
        }
        btnDeleteContact.setOnClickListener {
            deleteContact()
        }

    }

    private fun deleteContact() {
        doAsync {
            contactDb.delete(selectedContact)
            uiThread {
                finish()
            }
        }
    }

    private fun updateContact() {
        val updatedContact: Contact = Contact(
            selectedId,
            editContactFirstname.text.toString(),
            editContactLastname.text.toString(),
            editContactEmail.text.toString(),
            editContactAddress.text.toString()
        )
        if (updatedContact.checkIntegrity()) {
            doAsync {
                contactDb.update(updatedContact)
                uiThread {
                    finish()
                }
            }
        }
        else {
            contentView?.snackbar("Une erreur a été détectée dans votre saisie !")
        }
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
