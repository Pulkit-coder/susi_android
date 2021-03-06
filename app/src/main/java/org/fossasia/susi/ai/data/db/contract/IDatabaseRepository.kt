package org.fossasia.susi.ai.data.db.contract

import io.realm.RealmResults
import org.fossasia.susi.ai.data.db.ChatArgs
import org.fossasia.susi.ai.data.model.ChatMessage

/**
 * The interface for Database Repository
 *
 * Created by chiragw15 on 12/7/17.
 */
interface IDatabaseRepository {

    interface OnDatabaseUpdateListener {
        fun onDatabaseUpdateSuccess()
        fun updateMessageCount()
    }

    fun getMessageCount(): Long
    fun getAMessage(index: Long): ChatMessage?
    fun deleteAllMessages()
    fun getUndeliveredMessages(): RealmResults<ChatMessage>
    fun getAllMessages(): RealmResults<ChatMessage>
    fun getSearchResults(query: String): RealmResults<ChatMessage>
    fun closeDatabase()
    fun updateDatabase(chatArgs: ChatArgs, listener: OnDatabaseUpdateListener)
}
