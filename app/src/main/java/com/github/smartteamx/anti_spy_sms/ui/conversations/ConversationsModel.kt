package com.github.smartteamx.anti_spy_sms.ui.conversations

import com.github.smartteamx.anti_spy_sms.base.BaseModel
import com.github.smartteamx.anti_spy_sms.data.repositories.ConversationsRepository

class ConversationsModel(private val repo: ConversationsRepository) : BaseModel() {
    suspend fun getConversations(page: Int) = repo.getConversations(page)


}