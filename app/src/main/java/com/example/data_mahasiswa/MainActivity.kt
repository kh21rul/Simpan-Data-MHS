package com.example.data_mahasiswa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data_mahasiswa.room.NoteDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var list_note:RecyclerView
    private lateinit var button_create:Button
    val db by lazy { NoteDB(this)}
    lateinit var noteAdapter: Note_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_create=findViewById(R.id.button_create)
        list_note=findViewById(R.id.list_note)
        setupListener()
        setupRecyclearView()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val notei=db.noteDao().getNotes()
            Log.d("MainActivity", "dbResponse: $notei")
            withContext(Dispatchers.Main) {
                noteAdapter.setData(notei)
            }
        }
    }

    fun setupListener() {
        button_create.setOnClickListener {
            startActivity(Intent(this,EditActivity::class.java))
        }
    }

    private fun setupRecyclearView() {
        noteAdapter= Note_Adapter(arrayListOf())
        list_note.apply {
            layoutManager=LinearLayoutManager(applicationContext)
            adapter=noteAdapter
        }
    }
}