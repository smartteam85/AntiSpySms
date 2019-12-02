package com.github.smartteamx.anti_spy_sms.util.navigation

import android.app.Activity
import androidx.navigation.NavController

/**
 * Navigates up if fragment exists or finish the activity
 */
fun NavController.navigateUpOrFinish(activity: Activity?) {
    if (!navigateUp())
        activity?.finish()
}