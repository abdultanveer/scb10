package com.example.scb10.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Item(
    @PrimaryKey(autoGenerate=true)
    val uid: Int = 0,
    @ColumnInfo(name = "name")
    val itemName: String,
    val itemPrice: Double,
    val quantityInStock: Int
)