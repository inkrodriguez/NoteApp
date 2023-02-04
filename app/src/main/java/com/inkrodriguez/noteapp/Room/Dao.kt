package com.inkrodriguez.noteapp.Room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@androidx.room.Dao
interface Dao{

    @Insert
    suspend fun insertNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM NoteEntity")
    suspend fun findNote(): List<NoteEntity>

    @Update
    suspend fun updateNote(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)


}