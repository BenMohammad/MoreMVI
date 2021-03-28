package com.benmohammad.moremvi.presentation.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.benmohammad.moremvi.R
import com.benmohammad.moremvi.domain.entity.Persona
import kotlinx.android.synthetic.main.item_character.view.*

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.VH>() {

    private var charactersList: List<Persona> = ArrayList()

    class VH(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imageViewCharacterImage: ImageView = itemView.item_character_image
        private val textViewCharacterName: TextView = itemView.item_character_name

        fun bindCharacters(character: Persona) {
            with(character) {
                textViewCharacterName.text = name
                imageViewCharacterImage.load(image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_character, parent, false)
        return VH(itemView)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindCharacters(charactersList[position])
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

    fun updateList(characterList: List<Persona>) {
        charactersList = characterList
        notifyDataSetChanged()

    }
}