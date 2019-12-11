package com.github.smartteamx.anti_spy_sms.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.github.smartteamx.anti_spy_sms.util.Event
import com.github.smartteamx.anti_spy_sms.util.navigation.NavigationCommand

abstract class BaseViewModel(private val model: BaseModel) : ViewModel() {

    val navigationCommand =  MutableLiveData<Event<NavigationCommand>>()

    fun navigateTo(directions: NavDirections) {
        navigationCommand.postValue(Event(NavigationCommand.To(directions)))
    }

    fun navigateToWithFinish(directions: NavDirections) {
        navigationCommand.postValue(Event(NavigationCommand.ToWithFinish(directions)))
    }

    fun navigateTo(actionId: Int) {
        navigationCommand.postValue(Event(NavigationCommand.ToAction(actionId)))
    }

    fun navigateToWithFinish(actionId: Int) {
        navigationCommand.postValue(Event(NavigationCommand.ToActionWithFinish(actionId)))
    }

    fun navigateToRoot() {
        navigationCommand.postValue(Event(NavigationCommand.ToRoot))
    }

    fun navigateBack() {
        navigationCommand.postValue(Event(NavigationCommand.Back))
    }

    fun navigateBackTo(destinationId: Int, inclusive: Boolean) {
        navigationCommand.postValue(Event(NavigationCommand.BackTo(destinationId, inclusive)))
    }

}