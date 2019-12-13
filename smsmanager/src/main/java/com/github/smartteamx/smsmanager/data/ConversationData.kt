package com.github.smartteamx.smsmanager.data

import java.util.*

data class ConversationData(
    val id: Int,
    val threadId: Int,
    val snippet: String?,
    val date: Date,
    val address: String?,
    val seen: Boolean?,
    val read: Boolean?,
    val status: Int,
    val type: Int,
    val sim: Int?
)