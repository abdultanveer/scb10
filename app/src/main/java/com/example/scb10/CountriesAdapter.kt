package com.example.scb10

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.scb10.database.Item

class CountriesAdapter() : ListAdapter<Item, VisitigCardViewHolder>(VisitigCardViewHolder.WordsComparator()) {
    var TAG = CountriesAdapter::class.java.simpleName


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisitigCardViewHolder {
        Log.i(TAG,"navin bought a visiting card and gave it to harshit")
        return VisitigCardViewHolder.create(parent)

    }



    override fun onBindViewHolder(harshitholder: VisitigCardViewHolder, position: Int) {
        //harshitholder.visitingCardTv.setText(countries.get(position))
        val current = getItem(position)
        harshitholder.bind(current.itemName)
        Log.i(TAG,"shriya is writig --"+current.itemName)

    }
}

class VisitigCardViewHolder(vCard:View): RecyclerView.ViewHolder(vCard){
    init {
        Log.i("Adapter","vc holder --harshit got the card bought by navin")
    }
    var visitingCardTv:TextView = vCard.findViewById(R.id.tvVisitingCard)

    fun bind(text: String?) {
        visitingCardTv.text = text
    }

    companion object {
        fun create(parent: ViewGroup): VisitigCardViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.visiting_card, parent, false)
            return VisitigCardViewHolder(view)
        }
    }

    class WordsComparator : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.uid == newItem.uid
        }
    }

}
