package com.github.smartteamx.anti_spy_sms.di

import com.github.smartteamx.anti_spy_sms.data.repositories.ConversationsRepository
import com.github.smartteamx.anti_spy_sms.data.repositories.ConversationsRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Repository's module
 */
val repositoryModule = module {
    factory <ConversationsRepository>{ ConversationsRepositoryImpl(androidApplication()) }
}