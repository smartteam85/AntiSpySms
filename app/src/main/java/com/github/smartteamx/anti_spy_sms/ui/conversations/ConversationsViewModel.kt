package com.github.smartteamx.anti_spy_sms.ui.conversations

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.smartteamx.anti_spy_sms.base.BaseAndroidViewModel
import com.github.smartteamx.anti_spy_sms.data.ConversationItem
import kotlinx.coroutines.launch


class ConversationsViewModel(app: Application, private val model: ConversationsModel) :
    BaseAndroidViewModel(app, model) {
    val conversations = MutableLiveData<MutableList<ConversationItem?>>()


    fun getConversations(page: Int) {
        viewModelScope.launch {
            val a = model.getConversations(page)
            if (conversations.value == null || conversations.value?.isEmpty() != false) {
                conversations.value = a
            } else
                conversations.value?.let { it ->
                    conversations.value = (it + a).toMutableList()
                }

        }

    }
}