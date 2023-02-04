package com.inkrodriguez.noteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.inkrodriguez.noteapp.Room.NoteEntity

class Adapter(private val notes: List<NoteEntity>): RecyclerView.Adapter<Adapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount(): Int {
        return notes.size
    }


    class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(data: NoteEntity){
            with(itemView){
                val txtNote = findViewById<TextView>(R.id.textView)
                val txtAssunto = findViewById<TextView>(R.id.txtAssunto)

                txtNote.text = data.note
                txtAssunto.text = data.assunto
            }
        }
    }
}