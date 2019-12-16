package com.github.smartteamx.anti_spy_sms.di

import com.github.smartteamx.anti_spy_sms.ui.conversations.ConversationsModel
import com.github.smartteamx.anti_spy_sms.ui.main.MainModel
import org.koin.dsl.module

/**
 * Model's (M in M V VM) module
 */
val modelModule = module {
    factory { MainModel() }
    factory { ConversationsModel(get()) }
}