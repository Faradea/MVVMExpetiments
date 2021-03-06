package com.macgavrina.mvvmexpetiments.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.macgavrina.mvvmexpetiments.MainApplication
import com.macgavrina.mvvmexpetiments.model.Note
import com.macgavrina.mvvmexpetiments.repositories.NoteRepository

class NoteViewModel(application: Application) : AndroidViewModel(MainApplication.instance) {

    private var repository: NoteRepository = NoteRepository(application)
    private var allNotes: LiveData<List<Note>> = repository.getAllNotes()

    fun insert(note: Note) {
        repository.insert(note)
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes
    }
}