package com.example.data_mahasiswa.room

import androidx.room.*

@Dao
interface NoteDao {
    @Insert
    fun addNote(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("Select * from note")
    fun getNotes():List<Note>
}