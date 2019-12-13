package com.github.smartteamx.anti_spy_sms.data

import com.github.smartteamx.smsmanager.data.ConversationData
import java.util.*
import kotlin.reflect.full.memberProperties

class ConversationItem {
    val id: Int
    val threadId: Int
    val snippet: String?
    val date: Date
    val address: String?
    val seen: Boolean?
    val read: Boolean?
    val status: Int
    val type: Int
    val sim: Int?

    constructor(data: ConversationData) {
        id = data.id
        threadId = data.threadId
        snippet = data.snippet
        date = data.date
        address = data.address
        seen = data.seen
        read = data.read
        status = data.status
        type = data.type
        sim = data.sim
    }

    constructor(
        id: Int,
        threadId: Int,
        snippet: String?,
        date: Date,
        address: String?,
        seen: Boolean?,
        read: Boolean?,
        status: Int,
        type: Int,
        sim: Int?
    ) {
        this.id = id
        this.threadId = threadId
        this.snippet = snippet
        this.date = date
        this.address = address
        this.seen = seen
        this.read = read
        this.status = status
        this.type = type
        this.sim = sim
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }

        if(other !is ConversationItem){
            return false
        }


        for (field in ConversationItem::class.memberProperties) {
            if (field.get(this) != field.get(other))
                return false
        }

        return true
    }

}