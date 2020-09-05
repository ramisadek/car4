package com.dawn.car4.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dawn.car4.R
import com.dawn.car4.databinding.ItemContactBinding
import com.dawn.car4.models.Contacts
import java.lang.reflect.Array

class ContactsAdapter : ListAdapter<Contacts,
        ContactsAdapter.ViewHolder>(SleepNightDiffCallback()) {

    private var mcontacts : ArrayList<Contacts> = ArrayList<Contacts>()

    fun addMoreContacts(mainList : ArrayList<Contacts>){
        this.mcontacts =mainList
        submitList(mcontacts)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        // Get the data model based on position
        //val contact: Contacts = mContacts.get(position)
        // Set item views based on your views and data model
//        val textView = viewHolder.nameTextView
//        textView.setText(contact.name)
//        val button = viewHolder.messageButton
//        button.text = if (contact.isOnline) "Message" else "Offline"
//        button.isEnabled = contact.isOnline
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val context = parent.context
//        val inflater = LayoutInflater.from(context)
//        // Inflate the custom layout
//        val contactView = inflater.inflate(R.layout.item_contact, parent, false)
//        // Return a new holder instance
//        return ViewHolder(contactView)
        return ViewHolder.from(parent)
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
     class ViewHolder private constructor (val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row

        fun bind(item: Contacts) {
            println(item.isOnline)
            binding.contact = item
            binding.bb.setOnClickListener {
                binding.bb.text = "whatever"
                item.name.value = "mamaia"
                binding.title.text = item.name.value
            }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemContactBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

//        val nameTextView = itemView.findViewById<TextView>(R.id.contact_name)
//        val messageButton = itemView.findViewById<Button>(R.id.message_button)
    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder


//    // Returns the total count of items in the list
//    override fun getItemCount(): Int {
//        return mContacts.size
//    }
}

class SleepNightDiffCallback : DiffUtil.ItemCallback<Contacts>() {
    override fun areItemsTheSame(oldItem: Contacts, newItem: Contacts): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Contacts, newItem: Contacts): Boolean {
        return oldItem == newItem
    }
}