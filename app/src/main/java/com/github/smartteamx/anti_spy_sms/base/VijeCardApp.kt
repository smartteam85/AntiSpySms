package com.github.smartteamx.anti_spy_sms.base

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.github.smartteamx.anti_spy_sms.BuildConfig
import com.jakewharton.threetenabp.AndroidThreeTen
import timber.log.Timber

/**
 * Custom application class
 */
class AntiSpySmsApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        // Plant Timber logger in
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        // Init Time
        AndroidThreeTen.init(this)

        // Support Vector drawables for pre lollipop devices
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

}