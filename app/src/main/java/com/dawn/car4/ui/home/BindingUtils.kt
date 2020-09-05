package com.dawn.car4.ui.home

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.dawn.car4.R
import com.dawn.car4.models.Contacts


@BindingAdapter("contactImage")
fun ImageView.setSleepImage(item: Contacts?) {
    item?.let {
        setImageResource(R.drawable.ic_launcher_foreground)
    }
}

@BindingAdapter("contactName")
fun TextView.setSleepDurationFormatted(item: Contacts?) {
    item?.let {
        text = item.name.value
    }
}

@BindingAdapter("contactID")
fun TextView.setSleepQualityString(item: Contacts?) {
    item?.let {
        text = item.id.toString()
    }
}