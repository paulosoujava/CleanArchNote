package com.paulo.cleannotes.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.paulo.cleannotes.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase: RoomDatabase() {
    abstract val noteDao: NoteDao
    companion object {
        const val DATABASE = "notes.db"
    }
}