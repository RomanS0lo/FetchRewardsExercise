package com.example.fetchrewardscodingexercise.data.repository

import com.example.fetchrewardscodingexercise.data.Item
import javax.inject.Inject

class ItemRepository @Inject constructor(private val service: ItemService) {

    suspend fun getItems(): List<Item> {
        return service.getItems().filter { it.name?.isNotBlank() == true }
    }
}
