package com.example.fetchrewardscodingexercise.ui.listScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchrewardscodingexercise.data.Item
import com.example.fetchrewardscodingexercise.data.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class ItemListViewModel@Inject constructor(private val repository: ItemRepository) :
    ViewModel() {

    // MutableStateFlow to hold the list of items
    private val localItems = MutableStateFlow<List<Item>>(emptyList())

    // Publicly exposed StateFlow to observe the items
    val items: StateFlow<List<Item>> = localItems

    // Initialization block to load the items when the ViewModel is created
    init {
        viewModelScope.launch {
            // Fetch items from the repository, filter out items with blank or null names,
            // sort them by listId and name, then group them by listId and flatten the list
            val items = repository.getItems()
                .filter { !it.name.isNullOrBlank() }
                .sortedWith(compareBy({ it.listId }, { it.name }))
                .groupBy { it.listId }
                .flatMap { entry -> entry.value }

            // Update the MutableStateFlow with the sorted and filtered items
            localItems.value = items
        }
    }
}
