package com.github.smartteamx.anti_spy_sms.ui.conversations

import androidx.recyclerview.widget.DiffUtil
import com.github.smartteamx.anti_spy_sms.R
import com.github.smartteamx.anti_spy_sms.base.BaseAdapter
import com.github.smartteamx.anti_spy_sms.data.ConversationItem

class ConversationsAdapter : BaseAdapter<ConversationItem>(DIFF_CALLBACK) {
    override fun getItemViewType(position: Int): Int {
        return R.layout.item_conversation
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ConversationItem>() {
            override fun areItemsTheSame(
                oldItem: ConversationItem,
                newItem: ConversationItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ConversationItem,
                newItem: ConversationItem
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

}