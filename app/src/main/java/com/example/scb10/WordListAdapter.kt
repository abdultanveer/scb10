package com.example.scb10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.scb10.networking.MarsPhoto

class WordListAdapter : ListAdapter<MarsPhoto, WordListAdapter.WordViewHolder>(WordsComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }
    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }
    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemView: TextView = itemView.findViewById(R.id.textViewurl)
        private val tvid: TextView = itemView.findViewById(R.id.textViewId)
        private val imageView:ImageView = itemView.findViewById(R.id.imageViewVC)

        fun bind(marsPhoto: MarsPhoto) {
            wordItemView.text = marsPhoto.imgSrc
            tvid.text =marsPhoto.id
            imageView.load(marsPhoto.imgSrc)
        }
        companion object {
            fun create(parent: ViewGroup): WordViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.visiting_card, parent, false)
                return WordViewHolder(view)
            }
        }
    }
    class WordsComparator : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrc == newItem.imgSrc
        }
    }
}