package com.github.smartteamx.anti_spy_sms.base

import android.app.Application

abstract class BaseAndroidViewModel(
    application: Application,
    model: BaseModel
) : BaseViewModel(model) {

    protected val application = application as AntiSpySmsApp
}