package com.github.smartteamx.anti_spy_sms.di

import com.github.smartteamx.anti_spy_sms.ui.conversations.ConversationsAdapter
import org.koin.dsl.module

/**
 * RecyclerView's adapters module
 */
val adapterModule = module {
    factory { ConversationsAdapter() }
}