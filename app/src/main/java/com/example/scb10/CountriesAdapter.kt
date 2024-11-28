package com.example.scb10

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountriesAdapter(var countries: Array<String>) :RecyclerView.Adapter<VisitigCardViewHolder>() {
    var TAG = CountriesAdapter::class.java.simpleName


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisitigCardViewHolder {
        Log.i(TAG,"navin bought a visiting card and gave it to harshit")
        var visitingCard = LayoutInflater.from(parent.context).inflate(R.layout.visiting_card,parent,false)
        return VisitigCardViewHolder(visitingCard)
    }

    override fun getItemCount(): Int {
        Log.i(TAG,"sanjay counted --"+countries.size)
        return countries.size
    }

    override fun onBindViewHolder(harshitholder: VisitigCardViewHolder, position: Int) {
        Log.i(TAG,"shriya is writig --"+countries.get(position))
        harshitholder.visitingCardTv.setText(countries.get(position))
    }
}

class VisitigCardViewHolder(vCard:View): RecyclerView.ViewHolder(vCard){
    init {
        Log.i("Adapter","vc holder --harshit got the card bought by navin")
    }
    var visitingCardTv:TextView = vCard.findViewById(R.id.tvVisitingCard)

}
