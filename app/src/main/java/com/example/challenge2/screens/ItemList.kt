package com.example.challenge2.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.challenge2.R
import com.example.challenge2.components.MyModal
import com.example.challenge2.components.ProductItem
import com.example.challenge2.data.Product
import com.example.challenge2.data.sampleProducts
import com.example.challenge2.ui.theme.DarkBrown
import com.example.challenge2.ui.theme.ModalIconColor

@Composable
fun ItemList(
        favorites: MutableList<Product>
) {
        val showAddedToFavDialog = remember { mutableStateOf(false) }
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
                                                showAddedToFavDialog.value = true
                                        }
                                }
                        )
                }
        }
        MyModal(
                open = showAddedToFavDialog.value,
                close = { showAddedToFavDialog.value = false },
                confirmAction = { showAddedToFavDialog.value = false },
                cancelButtonText = R.string.atf_cancel_button,
                confirmButtonText = R.string.atf_confirm_button,
                title = R.string.atf_title,
                content = { Text( stringResource(R.string.atf_content), color = DarkBrown) },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.cell_phone),
                        contentDescription = null,
                        tint = ModalIconColor
                    )
                }
        )
}