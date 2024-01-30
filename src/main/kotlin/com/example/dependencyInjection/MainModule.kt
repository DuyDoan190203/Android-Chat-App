package com.example.dependencyInjection

import MessageDataSource
import com.example.data.model.MessageDataSourceImpl
import com.example.room.RoomController
import org.litote.kmongo.reactivestreams.KMongo
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine

val mainModule = module{
    single{
        KMongo.createClient()
            .coroutine
            .getDatabase("message_db_yt")
    }
    single<MessageDataSource>{
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}


