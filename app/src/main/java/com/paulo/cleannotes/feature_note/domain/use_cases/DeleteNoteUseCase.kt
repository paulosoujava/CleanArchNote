package com.paulo.cleannotes.feature_note.domain.use_cases

import com.paulo.cleannotes.feature_note.domain.model.Note
import com.paulo.cleannotes.feature_note.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)

    }
}