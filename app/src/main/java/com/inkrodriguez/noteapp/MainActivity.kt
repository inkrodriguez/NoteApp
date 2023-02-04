package com.inkrodriguez.noteapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.inkrodriguez.noteapp.Room.AppDataBase
import com.inkrodriguez.noteapp.Room.NoteEntity
import com.inkrodriguez.noteapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onResume() {
        super.onResume()

        getList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.imageView.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddNoteActivity::class.java))
        }

    }

    fun getList() {
        lifecycleScope.launch {
            var resultado = AppDataBase(applicationContext).getUserDao().findNote()

            resultado.forEach {
                it.toString()
            }

            val recyclerView = binding.recyclerView
            val adapter = Adapter(resultado)
            recyclerView.adapter = adapter

        }
    }

}