package com.github.smartteamx.smsmanager

import android.app.PendingIntent
import android.content.Context
import android.database.Cursor
import android.provider.Telephony
import com.github.smartteamx.smsmanager.data.ConversationData
import com.github.smartteamx.smsmanager.exceptions.InvalidPageNumberException
import com.github.smartteamx.smsmanager.utils.getConversation


class SMSManager(private val context: Context, val pageCount: Int = 20) {


    fun sendSMS(
        phoneNumber: String,
        message: String,
        sentIntent: PendingIntent? = null,
        deliveryIntent: PendingIntent? = null
    ) {
        val sms = SendSMS()
        sms.send(phoneNumber, message, sentIntent, deliveryIntent)
    }

    fun getSMSConversations(page: Int): List<ConversationData> {
        if (page < 1) {
            throw InvalidPageNumberException(page)
        }
        val limitation = pageCount
        val offset = (page - 1) * pageCount

        val contentResolver = context.contentResolver
        var cursor: Cursor? = null
        val result = mutableListOf<ConversationData>()
        try {
            cursor = contentResolver.query(
                Telephony.Sms.CONTENT_URI,
                arrayOf("DISTINCT ${Telephony.Sms.THREAD_ID}", "*"),
                null,
                null,
                "${Telephony.Sms.Conversations.DATE} DESC LIMIT $limitation OFFSET $offset"
            )

            cursor?.apply {
                moveToFirst()
                do {
                    result.add(
                        getConversation()
                    )
                } while (moveToNext())

            }
        } catch (e: Exception) {
            throw e
        } finally {
            cursor?.close()
        }

        return result
    }


}