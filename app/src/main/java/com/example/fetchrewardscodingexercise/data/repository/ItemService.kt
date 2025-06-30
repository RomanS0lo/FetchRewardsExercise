package com.example.fetchrewardscodingexercise.data.repository

import com.example.fetchrewardscodingexercise.data.Item
import retrofit2.http.GET


interface ItemService {

    @GET("https://hiring.fetch.com/hiring.json")
    suspend fun getItems(): List<Item>
}
