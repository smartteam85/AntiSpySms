package com.github.smartteamx.anti_spy_sms.di

import com.github.smartteamx.anti_spy_sms.ui.conversations.ConversationsViewModel
import com.github.smartteamx.anti_spy_sms.ui.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * ViewModel's (VM in M V VM) module
 */
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { ConversationsViewModel(androidApplication(),get()) }
}