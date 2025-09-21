package com.example.challenge2.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.data.Product
import com.example.challenge2.R
import com.example.challenge2.types.ButtonType
import com.example.challenge2.ui.theme.CardBackground
import com.example.challenge2.ui.theme.DarkBrown
import com.example.challenge2.ui.theme.PrimaryBrown


@Composable
fun FavouriteItem(
    product: Product,
    index: Int,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row (modifier = Modifier.fillMaxWidth().background(CardBackground), horizontalArrangement = Arrangement.SpaceBetween) {
            Row (modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp), verticalAlignment = Alignment.CenterVertically) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .size(40.dp)
                        .background(PrimaryBrown, shape = RoundedCornerShape(100.dp))
                ) {
                    Text(
                        index.toString(),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                    )
                }

                Column(verticalArrangement = Arrangement.SpaceAround) {
                    Text(text = product.title, color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = product.price, color = DarkBrown)
                }
            }


            Image(
                painter = painterResource(id = R.drawable.product_placeholder),
                contentDescription = product.title,
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}