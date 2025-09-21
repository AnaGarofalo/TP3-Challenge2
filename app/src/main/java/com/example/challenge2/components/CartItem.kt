package com.example.challenge2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.data.Product
import com.example.challenge2.ui.theme.DarkBrown
import com.example.challenge2.ui.theme.PrimaryBrown
import com.example.challenge2.ui.theme.SecondaryBrown

@Composable
fun CartItem(
    product: Product,
    index: Int,
) {
    val checked = remember { mutableStateOf(true) }

    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Row (modifier = Modifier.padding(8.dp), horizontalArrangement = Arrangement.spacedBy(16.dp), verticalAlignment = Alignment.CenterVertically) {
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
                Text(text = product.title, color = DarkBrown, fontSize = 16.sp, lineHeight = 24.sp)
            }
        }

        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked.value = it },
            colors = CheckboxDefaults.colors(
                checkedColor = PrimaryBrown,
                uncheckedColor = PrimaryBrown,
                checkmarkColor = Color.White,
                disabledCheckedColor = Color.LightGray,
                disabledUncheckedColor = Color.Gray
            )
        )

    }

    Divider(
        color = SecondaryBrown,
        thickness = 1.dp,
    )

}