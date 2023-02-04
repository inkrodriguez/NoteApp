package com.inkrodriguez.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.inkrodriguez.noteapp.Room.AppDataBase
import com.inkrodriguez.noteapp.Room.NoteEntity
import com.inkrodriguez.noteapp.databinding.ActivityAddNoteBinding
import kotlinx.coroutines.launch

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnRegistrar.setOnClickListener {
            addUser()
        }
    }

    fun addUser() {
        lifecycleScope.launch {
            var txtNote = binding.editNote.editableText
            var txtAssunto = binding.editAssunto.editableText
            var noteEntity = NoteEntity(txtAssunto.toString(), txtNote.toString())
            AppDataBase(this@AddNoteActivity).getUserDao().insertNote(noteEntity)
            finish()
        }
    }
}