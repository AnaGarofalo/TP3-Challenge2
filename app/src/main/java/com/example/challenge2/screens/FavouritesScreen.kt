package com.example.challenge2.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.challenge2.components.ProductItem
import com.example.challenge2.data.Product
import com.example.challenge2.data.sampleProducts

@Composable
fun FavouritesScreen(
    favorites: MutableList<Product>
) {
    LazyColumn {
        items(sampleProducts) { product ->
            val isFavorite = favorites.contains(product)
            ProductItem(
                product = product,
                isFavorite = isFavorite,
                onFavoriteClick = {
                    if (isFavorite) {
                        favorites.remove(product)
                    } else {
                        favorites.add(product)
                    }
                }
            )
        }
    }
}