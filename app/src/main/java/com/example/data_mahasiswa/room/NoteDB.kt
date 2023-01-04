package com.example.data_mahasiswa.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDB: RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile private var instance: NoteDB?=null
        private val LOCk=Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCk) {
            instance ?: buildDatabase(context).also{
                instance=it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDB::class.java,
            "note123.db"
        ).build()
    }
}