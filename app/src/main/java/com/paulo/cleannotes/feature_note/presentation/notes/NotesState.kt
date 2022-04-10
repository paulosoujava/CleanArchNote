package com.paulo.cleannotes.feature_note.presentation.notes

import com.paulo.cleannotes.feature_note.domain.model.Note
import com.paulo.cleannotes.feature_note.domain.util.NoteOrder
import com.paulo.cleannotes.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false

)
