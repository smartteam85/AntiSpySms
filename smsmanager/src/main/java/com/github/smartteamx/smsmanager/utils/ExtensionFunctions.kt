package com.github.smartteamx.smsmanager.utils

import android.database.Cursor
import android.os.Build
import android.provider.Telephony
import com.github.smartteamx.smsmanager.data.ConversationData
import java.util.*

fun Cursor.getConversation(): ConversationData {
    val sdk = Build.VERSION.SDK_INT
    when {
        sdk < 22 -> return ConversationData(
            getInt(getColumnIndex(Telephony.Sms._ID)),
            getInt(getColumnIndex(Telephony.Sms.THREAD_ID)),
            getString(getColumnIndex(Telephony.Sms.BODY)),
            Date(getLong(getColumnIndex(Telephony.Sms.DATE))),
            getString(getColumnIndex(Telephony.Sms.ADDRESS)),
            getInt(getColumnIndex(Telephony.Sms.SEEN)) == 1,
            getInt(getColumnIndex(Telephony.Sms.READ)) == 1,
            getInt(getColumnIndex(Telephony.Sms.STATUS)),
            getInt(getColumnIndex(Telephony.Sms.TYPE)),
            null
        )
        sdk >= 23 -> return ConversationData(
            getInt(getColumnIndex(Telephony.Sms._ID)),
            getInt(getColumnIndex(Telephony.Sms.THREAD_ID)),
            getString(getColumnIndex(Telephony.Sms.BODY)),
            Date(getLong(getColumnIndex(Telephony.Sms.DATE))),
            getString(getColumnIndex(Telephony.Sms.ADDRESS)),
            getInt(getColumnIndex(Telephony.Sms.SEEN)) == 1,
            getInt(getColumnIndex(Telephony.Sms.READ)) == 1,
            getInt(getColumnIndex(Telephony.Sms.STATUS)),
            getInt(getColumnIndex(Telephony.Sms.TYPE)),
            getInt(getColumnIndex("sim_id"))

        )
        else -> return ConversationData(
            getInt(getColumnIndex(Telephony.Sms._ID)),
            getInt(getColumnIndex(Telephony.Sms.THREAD_ID)),
            getString(getColumnIndex(Telephony.Sms.BODY)),
            Date(getLong(getColumnIndex(Telephony.Sms.DATE))),
            getString(getColumnIndex(Telephony.Sms.ADDRESS)),
            getInt(getColumnIndex(Telephony.Sms.SEEN)) == 1,
            getInt(getColumnIndex(Telephony.Sms.READ)) == 1,
            getInt(getColumnIndex(Telephony.Sms.STATUS)),
            getInt(getColumnIndex(Telephony.Sms.TYPE)),
            getInt(getColumnIndex(Telephony.Sms.SUBSCRIPTION_ID))

        )
    }
}