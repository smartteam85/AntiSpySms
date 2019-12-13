package com.github.smartteamx.smsmanager

import android.content.Context
import androidx.test.espresso.internal.inject.InstrumentationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SendSMSTest {

    @get:Rule
    var permissionRule: GrantPermissionRule? =
        GrantPermissionRule.grant(android.Manifest.permission.SEND_SMS)

    val message = "this is test sms ${(Math.random() * 100).toInt()}"
    val phoneNumber = "5555215556"

    @InstrumentationContext
    lateinit var appContext: Context

    @Test
    fun sendMessage() {
        val sendSms = SMSManager(appContext)
        try {
            sendSms.sendSMS(phoneNumber, message)
            assert(true)
        } catch (e: Exception) {
            assert(false)
        }
    }
}