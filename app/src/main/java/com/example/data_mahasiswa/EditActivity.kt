package com.example.data_mahasiswa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.data_mahasiswa.room.Note
import com.example.data_mahasiswa.room.NoteDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {

    private lateinit var button_save:Button
    private lateinit var edit_jur:EditText
    private lateinit var edit_nama:EditText
    private lateinit var edit_nim:EditText

    val db by lazy { NoteDB(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        button_save=findViewById(R.id.button_save)
        edit_jur=findViewById(R.id.edit_jur)
        edit_nama=findViewById(R.id.edit_nama)
        edit_nim=findViewById(R.id.edit_nim)
        setupListener()
    }

    fun setupListener() {
        button_save.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.noteDao().addNote(
                    Note(0,edit_jur.text.toString(),edit_nama.text.toString(),Integer.parseInt(edit_nim.text.toString()))
                )
                finish()
            }
        }
    }
}