package com.example.fetchrewardscodingexercise.data.repository

import com.example.fetchrewardscodingexercise.data.Item
import retrofit2.http.GET


interface ItemService {

    @GET("https://fetch-hiring.s3.amazonaws.com/hiring.json")
    suspend fun getItems(): List<Item>
}
