package com.github.smartteamx.anti_spy_sms.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.smartteamx.anti_spy_sms.util.Event
import com.github.smartteamx.anti_spy_sms.util.navigation.NavigationCommand

abstract class BaseViewModel(private val model: BaseModel) : ViewModel() {

    val navigationCommand =  MutableLiveData<Event<NavigationCommand>>()

}