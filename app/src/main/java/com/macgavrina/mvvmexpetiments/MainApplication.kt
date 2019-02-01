package com.macgavrina.mvvmexpetiments

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.macgavrina.mvvmexpetiments.db.NoteDatabase
import com.macgavrina.mvvmexpetiments.model.Note

//This class is necessary to get application context - MainApplication.applicationContext()

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        db = Room.databaseBuilder(applicationContext,
                NoteDatabase::class.java, NoteDatabase.DATABASE_NAME).build()
    }

    companion object {

        lateinit var instance: MainApplication
            private set

        lateinit var db:NoteDatabase
            private set

        fun applicationContext() : Context {
            return instance.applicationContext
        }

    }

}