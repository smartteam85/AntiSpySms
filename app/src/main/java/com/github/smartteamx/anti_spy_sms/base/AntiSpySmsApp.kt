package com.github.smartteamx.anti_spy_sms.base

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.github.smartteamx.anti_spy_sms.BuildConfig
import com.github.smartteamx.anti_spy_sms.di.*
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
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

        // Initialize Koin DI
        startKoin {
            androidContext(this@AntiSpySmsApp)
            androidLogger(Level.DEBUG)
            modules(
                dbModule, securityModule, repositoryModule,
                viewModelModule, modelModule, adapterModule
            )
        }
    }

}