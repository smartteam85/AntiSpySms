package com.github.smartteamx.anti_spy_sms.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.smartteamx.anti_spy_sms.BR

abstract class BaseAdapter<T>(diffCallback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, BaseAdapter<T>.DataBindingViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
        return DataBindingViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                viewType,
                parent,
                false
            )
        )
    }

    override fun submitList(list: MutableList<T>?) {
        super.submitList(if (list != null) ArrayList<T>(list).toMutableList() else null)
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) =
        holder.bind(getItem(position))

    abstract override fun getItemViewType(position: Int): Int

    inner class DataBindingViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: T) {
            binding.apply {
                setVariable(BR.item, item)
                executePendingBindings()
            }

        }
    }
}