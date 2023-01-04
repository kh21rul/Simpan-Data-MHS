package com.example.data_mahasiswa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.data_mahasiswa.room.Note

class Note_Adapter(private val notes: ArrayList<Note>):
    RecyclerView.Adapter<Note_Adapter.NoteViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
            return NoteViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
            )
        }

        override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
            val note=notes[position]
            holder.text_title.text=note.nama
        }

        override fun getItemCount()= notes.size

        class NoteViewHolder(val view:View):RecyclerView.ViewHolder(view) {
            val text_title: TextView=view.findViewById(R.id.text_title)
        }

        fun setData(list:List<Note>) {
            notes.clear()
            notes.addAll(list)
            notifyDataSetChanged()
        }

    }
