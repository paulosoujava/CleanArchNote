package com.paulo.cleannotes.di

import android.app.Application
import androidx.room.Room
import com.paulo.cleannotes.feature_note.data.data_source.NoteDatabase
import com.paulo.cleannotes.feature_note.data.repository.NoteRepositoryImpl
import com.paulo.cleannotes.feature_note.domain.repository.NoteRepository
import com.paulo.cleannotes.feature_note.domain.use_cases.AddNote
import com.paulo.cleannotes.feature_note.domain.use_cases.DeleteNoteUseCase
import com.paulo.cleannotes.feature_note.domain.use_cases.GetNotesUseCase
import com.paulo.cleannotes.feature_note.domain.use_cases.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDataBase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(dao = db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases( repository: NoteRepository): NoteUseCases{
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository = repository),
            deleteNotes = DeleteNoteUseCase(repository = repository),
            addNote = AddNote(repository = repository)
        )
    }
}