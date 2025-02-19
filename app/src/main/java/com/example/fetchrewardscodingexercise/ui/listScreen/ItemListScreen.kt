package com.example.fetchrewardscodingexercise.ui.listScreen


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fetchrewardscodingexercise.data.Item

@Composable
fun ItemListScreen(itemListViewModel: ItemListViewModel = hiltViewModel()) {

    // Collect the items StateFlow as a state
    val items by itemListViewModel.items.collectAsState()

    // Display the items in a LazyColumn
    LazyColumn(contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(3.dp)) {
        Modifier
            .fillMaxSize()
            .padding(16.dp)
        Arrangement.spacedBy(8.dp)
        items(items) { item ->
            ItemRow(item)
        }
    }
}

@Composable
fun ItemRow(item: Item) {
    Column(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(8.dp)
    ) {
        Text("ID: ${item.id}", style = MaterialTheme.typography.bodySmall)
        Text("List ID: ${item.listId}", style = MaterialTheme.typography.bodySmall)
        Text("Name: ${item.name}", style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemRow() {
    val sampleItem = Item(id = 1, listId = 1, name = "Item 1")
    ItemRow(item = sampleItem)
}
