package com.paulo.cleannotes.feature_note.domain.use_cases

data class NoteUseCases(
    val getNotes: GetNotesUseCase,
    val getNote: GetNote,
    val deleteNotes: DeleteNoteUseCase,
    val addNote: AddNote
)
