package com.example.challenge2.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.data.Product
import com.example.challenge2.R
import com.example.challenge2.types.ButtonType
import com.example.challenge2.ui.theme.CardBackground
import com.example.challenge2.ui.theme.DarkBrown


@Composable
fun ProductItem(
    product: Product,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().background(CardBackground)) {
            Image(
                painter = painterResource(id = R.drawable.product_placeholder),
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = product.title, color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = product.price, color = DarkBrown)
            }

            Text(text = product.description, color = DarkBrown, modifier = Modifier.padding(16.dp))

            Row (
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End)
            ) {
                MyButton(
                    onClick = onFavoriteClick,
                    type = ButtonType.SECONDARY,
                    text = if (isFavorite) stringResource(R.string.p_remove_from_favourites) else stringResource(R.string.p_add_to_favourites))

                MyButton(
                    onClick = {},
                    text = stringResource(R.string.p_buy)
                )
            }
        }
    }
}