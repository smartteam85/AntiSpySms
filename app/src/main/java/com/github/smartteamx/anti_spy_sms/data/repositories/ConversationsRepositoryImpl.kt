package com.github.smartteamx.anti_spy_sms.data.repositories

import android.app.Application
import com.github.smartteamx.anti_spy_sms.data.ConversationItem
import com.github.smartteamx.smsmanager.SMSManager

class ConversationsRepositoryImpl(private val app: Application) : ConversationsRepository {
    override suspend fun getConversations(page: Int): MutableList<ConversationItem?> {
        val sms = SMSManager(app)
        val list = mutableListOf<ConversationItem?>()
        return sms.getSMSConversations(page).mapTo(list) { ConversationItem(it) }

    }
}