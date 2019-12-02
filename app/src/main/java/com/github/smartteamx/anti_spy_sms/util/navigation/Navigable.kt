package com.github.smartteamx.anti_spy_sms.util.navigation

import android.app.Activity
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.github.smartteamx.anti_spy_sms.base.BaseViewModel
import com.github.smartteamx.anti_spy_sms.util.EventObserver

interface Navigable {
    fun makeViewModelNavigable(
        viewModel: BaseViewModel?,
        activity: Activity?,
        lifecycleOwner: LifecycleOwner,
        navController: NavController
    )
}

class NavigableDelegation : Navigable {

    override fun makeViewModelNavigable(
        viewModel: BaseViewModel?,
        activity: Activity?,
        lifecycleOwner: LifecycleOwner,
        navController: NavController
    ) {
        viewModel?.navigationCommand?.observe(lifecycleOwner, EventObserver { command ->
            when (command) {
                is NavigationCommand.To ->
                    navController.navigate(command.directions)
                is NavigationCommand.ToWithFinish -> {
                    navController.navigate(command.directions)
                    activity?.finish()
                }
                is NavigationCommand.ToAction ->
                    navController.navigate(command.actionId)
                is NavigationCommand.ToActionWithFinish -> {
                    navController.navigate(command.actionId)
                    activity?.finish()
                }
                is NavigationCommand.Back ->
                    navController.navigateUpOrFinish(activity)
                is NavigationCommand.BackTo ->
                    navController.popBackStack(command.destinationId, command.inclusive)
                is NavigationCommand.ToRoot -> {
                    TODO("12/2/2019 we need to add the homepage of app and complete this section")
                    //navController.popBackStack(R.id.home, false)
                }
            }
        })
    }
}