package com.ynovaix.smartydays.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ynovaix.smartydays.R
import com.ynovaix.smartydays.activity.EditContactActivity
import com.ynovaix.smartydays.activity.NewContactActivity
import com.ynovaix.smartydays.model.Contact
import com.ynovaix.smartydays.model.ContactDb
import com.ynovaix.smartydays.model.ContactDbHelper
import com.ynovaix.smartydays.util.ContactAdapter
import com.ynovaix.smartydays.util.EmptyAdapter
import kotlinx.android.synthetic.main.fragment_contact.view.*
import org.jetbrains.anko.*

class ContactFragment : Fragment(), AnkoLogger {

    private val contactDb by lazy { ContactDb(ContactDbHelper(context?.applicationContext)) }
    private var list = listOf<Contact>()
    private lateinit var contactView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        contactView = inflater.inflate(R.layout.fragment_contact, container, false)

        contactView.addContact.setOnClickListener {
            launchAddContactActivity()
        }

        contactView.contactSearchField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                updateListBySearch(s.toString())
            }
        })

        contactView.contactRecyclerView.layoutManager = LinearLayoutManager(context?.applicationContext)
        contactView.contactRecyclerView.adapter = EmptyAdapter()

        updateRecyclerView()

        // Inflate the layout for this fragment
        return contactView
    }

    private fun updateListBySearch(str: String) {
        doAsync {
            list = contactDb.getAllBySearch(str)
            uiThread {
                updateAdapter()
            }
        }
    }

    private fun launchAddContactActivity() {
        context?.startActivity<NewContactActivity>()
    }

    private fun updateRecyclerView() {
        doAsync {
            list = contactDb.getAll()
            uiThread {
                updateAdapter()
            }
        }
    }

    private fun updateAdapter() {
        contactView.contactRecyclerView.adapter = ContactAdapter(list, object : ContactAdapter.OnItemClickListener {
            override fun onItemClick(contact: Contact) {
                // launch activity with contact item
                context?.startActivity<EditContactActivity>(
                    "selectedId" to contact.id
                )
            }
        })
    }

    override fun toString(): String {
        return "contact_fragment"
    }

}