package com.example.scb10.database

import kotlinx.coroutines.flow.Flow

//like a kitchen -- fetch the data from local/remote source

class ItemRepository(private val itemDao: ItemDao) {

    val allItems: Flow<List<Item>> = itemDao.getItems()


    suspend fun getUserById(id: Int): Flow<Item?> {
        return itemDao.getItem(id)//3
    }

    suspend fun insert(item: Item) {
        itemDao.insert(item)
    }
}