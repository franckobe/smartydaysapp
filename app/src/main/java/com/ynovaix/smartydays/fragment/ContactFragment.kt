package com.ynovaix.smartydays.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ynovaix.smartydays.R
import com.ynovaix.smartydays.activity.NewContactActivity
import com.ynovaix.smartydays.model.Contact
import com.ynovaix.smartydays.model.ContactDb
import com.ynovaix.smartydays.model.ContactDbHelper
import com.ynovaix.smartydays.util.ContactAdapter
import com.ynovaix.smartydays.util.EmptyAdapter
import kotlinx.android.synthetic.main.fragment_contact.*
import kotlinx.android.synthetic.main.fragment_contact.view.*
import org.jetbrains.anko.*

class ContactFragment : Fragment(), AnkoLogger {

    private val contactDb by lazy { ContactDb(ContactDbHelper(context?.applicationContext)) }
    private var list = listOf<Contact>()
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var contactView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        contactView = inflater.inflate(R.layout.fragment_contact, container, false)

        contactView.addContact.setOnClickListener {
            launchAddContactActivity()
        }

        contactAdapter = ContactAdapter(list)
        contactView.contactRecyclerView.layoutManager = LinearLayoutManager(context?.applicationContext)
        contactView.contactRecyclerView.adapter = EmptyAdapter()

        updateList()

        // Inflate the layout for this fragment
        return contactView
    }

    private fun launchAddContactActivity() {
        context?.startActivity<NewContactActivity>()
    }

    private fun updateList() {
        doAsync {
            list = contactDb.getAll()
            uiThread {
                updateAdapter()
            }
        }
    }

    private fun updateAdapter() {
        contactView.contactRecyclerView.adapter = ContactAdapter(list)
    }

    override fun toString(): String {
        return "contact_fragment"
    }

}