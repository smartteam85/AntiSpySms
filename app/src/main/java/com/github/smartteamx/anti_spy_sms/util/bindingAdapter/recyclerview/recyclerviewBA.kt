package com.github.smartteamx.anti_spy_sms.util.bindingAdapter.recyclerview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.smartteamx.anti_spy_sms.base.BaseAdapter

@Suppress("UNCHECKED_CAST")
@BindingAdapter("data")
fun <T> RecyclerView.setItems(items: MutableList<T>?) {
    if (adapter is BaseAdapter<*>) {
        (adapter as BaseAdapter<T>).submitList(items)
    }
}
