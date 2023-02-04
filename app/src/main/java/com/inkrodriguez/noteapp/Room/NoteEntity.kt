package com.inkrodriguez.noteapp.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class NoteEntity(var assunto: String = "", var note: String = ""){

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}