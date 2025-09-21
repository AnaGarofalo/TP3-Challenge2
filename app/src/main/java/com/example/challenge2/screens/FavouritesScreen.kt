package com.example.challenge2.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.challenge2.components.FavouriteItem
import com.example.challenge2.data.Product

@Composable
fun FavouritesScreen(
    favorites: MutableList<Product>
) {
    LazyColumn {
        items(favorites) { product ->
            FavouriteItem(
                product = product,
                index = favorites.indexOf(product) + 1
            )
        }
    }
}