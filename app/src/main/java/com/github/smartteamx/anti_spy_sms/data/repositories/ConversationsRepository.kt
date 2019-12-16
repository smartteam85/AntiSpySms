package com.github.smartteamx.anti_spy_sms.data.repositories

import com.github.smartteamx.anti_spy_sms.data.ConversationItem

interface ConversationsRepository {
    suspend fun getConversations(page: Int): MutableList<ConversationItem?>
}