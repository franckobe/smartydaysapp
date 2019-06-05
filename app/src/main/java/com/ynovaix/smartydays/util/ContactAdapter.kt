package com.ynovaix.smartydays.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ynovaix.smartydays.R
import com.ynovaix.smartydays.model.Contact
import kotlinx.android.synthetic.main.list_item_contact.view.*

class ContactAdapter(private var items: List<Contact>): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindContact(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): ViewHolder {
        val lineView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_contact, parent, false)
        return ViewHolder(lineView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bindContact(contact: Contact) {
            itemView.list_item_contact_firstname.text = contact.firstname
            itemView.list_item_contact_lastname.text = contact.lastname
        }
    }

}