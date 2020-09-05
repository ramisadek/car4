package com.dawn.car4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dawn.car4.databinding.ActivityMainBinding
import com.dawn.car4.ui.home.ContactsAdapter
import com.dawn.car4.models.Contacts

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this


        // ...
        // Lookup the recyclerview in activity layout
       // val rvContacts = findViewById<View>(R.id.rvContacts) as RecyclerView
        // Initialize contacts
        val contacts = Contacts.createContactsList(20)
        // Create adapter passing in the sample user data
        
        val adapter = ContactsAdapter()
        adapter.addMoreContacts(contacts)
        // Attach the adapter to the recyclerview to populate items
        binding.rvContacts.adapter = adapter

        // Set layout manager to position the items
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        // That's all!

    }
}