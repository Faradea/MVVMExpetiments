package com.macgavrina.mvvmexpetiments.repositories

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.macgavrina.mvvmexpetiments.MainApplication
import com.macgavrina.mvvmexpetiments.db.NoteDao
import com.macgavrina.mvvmexpetiments.model.Note
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class NoteRepository(application: Application) {

    private var noteDao: NoteDao = MainApplication.db.noteDao()

    private var allNotes: LiveData<List<Note>>

    init {
        allNotes = noteDao.getAllNotes()
    }


    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes

        //    fun getUsersFromApi(): Observable<List<User>> {
        //        return userApi.getUsers()
        //                .doOnNext {
        //                    Timber.d("Dispatching ${it.size} users from API...")
        //                    storeUsersInDb(it)
        //                }
    }

    fun deleteAllNotes() {

        Observable.fromCallable { noteDao.deleteAllNotes() }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe {
                Log.d("AppLogs", "All notes are deleted")
            }

        //return Observable.fromCallable { noteDao.deleteAllNotes() }
    }

    fun insert(note: Note) {

        Observable.fromCallable { noteDao.insert(note) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe {
                Log.d("AppLogs", "Note is inserted")
            }

    }

}