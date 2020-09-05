package com.dawn.car4.models

import androidx.lifecycle.MutableLiveData

data class Contacts(val name: MutableLiveData<String>, val id: Int, var isOnline: Boolean, val photo: String) {

    companion object {
        private var lastContactId = 0
        fun createContactsList(numContacts: Int): ArrayList<Contacts> {
            val contacts = ArrayList<Contacts>()
            for (i in 1..numContacts) {
                val namex: MutableLiveData<String> = MutableLiveData<String>()
                namex.value = "Person " + i
                contacts.add(Contacts(namex, i,i <= numContacts / 2, "https://coupon-free.com/wp-content/uploads/2020/01/carrefour-logo-vector-400x400-1-1.png"))
            }
            return contacts
        }
    }
}