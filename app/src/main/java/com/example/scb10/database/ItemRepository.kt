package com.example.scb10.database

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

//like a kitchen -- fetch the data from local/remote source

class ItemRepository(private val itemDao: ItemDao) {

    suspend fun getUserById(id: Int): Flow<Item?> {
        return itemDao.getItem(id)//3
    }

    suspend fun insert(item: Item) {
        itemDao.insert(item)
    }
}