package com.github.smartteamx.smsmanager

import android.app.PendingIntent
import android.telephony.SmsManager


internal class SendSMS {

    fun send(
        phoneNo: String,
        msg: String,
        sentIntent: PendingIntent? = null,
        deliveryIntent: PendingIntent? = null
    ) {
        val smsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(phoneNo, null, msg, sentIntent, deliveryIntent)
    }


}