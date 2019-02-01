package com.macgavrina.mvvmexpetiments.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.macgavrina.mvvmexpetiments.model.Note

@Database(entities = [Note::class], version = NoteDatabase.DATABASE_VERSION)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

//    private var instance: NoteDatabase? = null

//    fun getInstance(context: Context): NoteDatabase? {
//        if (instance == null) {
//            synchronized(NoteDatabase::class) {
//                instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    NoteDatabase::class.java, "notes_database"
//                )
//                    .fallbackToDestructiveMigration()
//                    //.addCallback(roomCallback)
//                    .build()
//            }
//        }
//        return instance
//    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "MainDB"
    }

}