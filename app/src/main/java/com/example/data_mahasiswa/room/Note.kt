package com.example.data_mahasiswa.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val jurusan:String,
    val nama:String,
    val nim:Int
)