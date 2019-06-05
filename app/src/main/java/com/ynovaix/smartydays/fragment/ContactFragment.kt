package com.ynovaix.smartydays.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ynovaix.smartydays.R
import com.ynovaix.smartydays.activity.NewContactActivity
import com.ynovaix.smartydays.model.Contact
import com.ynovaix.smartydays.model.ContactDb
import com.ynovaix.smartydays.model.ContactDbHelper
import kotlinx.android.synthetic.main.fragment_item2.*
import kotlinx.android.synthetic.main.fragment_item2.view.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivity

class ContactFragment : Fragment(), AnkoLogger {

    private val contactDb by lazy { ContactDb(ContactDbHelper(context?.applicationContext)) }
    private var list = listOf<Contact>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_item2, container, false)
        view.addContact.setOnClickListener {
            launchAddContactActivity()
        }
        updateList()

        // Inflate the layout for this fragment
        return view
    }

    private fun launchAddContactActivity() {
        context?.startActivity<NewContactActivity>()
    }

    private fun deleteContact(contact: Contact) {
        doAsync {
            contactDb.delete(contact)
            updateList()
            showList()
        }
    }

    private fun updateList() {
        doAsync {
            list = contactDb.getAll()
            showList()
        }
    }

    private fun showList() {
        info("NB CONTACT : ${list.size}")
        for (c in list)
            info("${c.id} : ${c.firstname} ${c.lastname}")
    }

    override fun toString(): String {
        return "contact_fragment"
    }

}