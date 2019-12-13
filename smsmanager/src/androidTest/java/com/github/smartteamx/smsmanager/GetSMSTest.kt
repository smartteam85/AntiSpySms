package com.github.smartteamx.smsmanager

import android.content.Context
import androidx.test.espresso.internal.inject.InstrumentationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class GetSMSTest {

    @get:Rule
    var permissionRule: GrantPermissionRule? =
        GrantPermissionRule.grant(android.Manifest.permission.READ_SMS)

    @InstrumentationContext
    lateinit var appContext: Context


    @Test
    fun readSMSConversations() {
        val smsManager = SMSManager(appContext)

        val list = smsManager.getSMSConversations(1)
        println("list count is ${list.size}")

    }
}