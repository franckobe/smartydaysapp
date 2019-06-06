package com.ynovaix.smartydays.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ynovaix.smartydays.R
import com.ynovaix.smartydays.model.Contact
import com.ynovaix.smartydays.model.ContactDb
import com.ynovaix.smartydays.model.ContactDbHelper
import com.ynovaix.smartydays.util.ContactRequestCode
import kotlinx.android.synthetic.main.activity_new_contact.*
import org.jetbrains.anko.contentView
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NewContactActivity : AppCompatActivity() {

    private val contactDb by lazy { ContactDb(ContactDbHelper(applicationContext)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_contact)

        btnAddNewContact.setOnClickListener {
            saveContact()
        }

    }

    private fun saveContact() {
        val contact = Contact(
            0,
            newContactFirstname.text.toString(),
            newContactLastname.text.toString(),
            newContactEmail.text.toString(),
            newContactAddress.text.toString()
        )
        if (contact.checkIntegrity()) {
            doAsync {
                contactDb.save(contact)
                uiThread {
                    finish()
                }
            }
        }
        else {
            contentView?.snackbar("Une erreur a été détectée dans votre saisie !")
        }
    }

}
