package com.example.scb10.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemDao {
//innsert innto Item where values()

    @Insert
    suspend fun insert(groceryItem: Item)
    @Update
    suspend   fun update(item: Item)
    @Delete
    suspend fun delete(item: Item)

    fun getItem(id: Int): Flow<Item>
    fun getItems(): Flow<List<Item>>
}