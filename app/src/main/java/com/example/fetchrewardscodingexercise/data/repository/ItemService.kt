package com.example.fetchrewardscodingexercise.data.repository

import com.example.fetchrewardscodingexercise.data.Item
import retrofit2.http.GET


interface ItemService {

    @GET("hiring.json")
    suspend fun getItems(): List<Item>
}
