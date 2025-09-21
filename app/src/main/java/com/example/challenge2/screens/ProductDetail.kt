package com.example.challenge2.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.challenge2.R
import com.example.challenge2.components.MyButton
import com.example.challenge2.components.MyInput
import com.example.challenge2.components.MySelect
import com.example.challenge2.data.Product
import com.example.challenge2.types.ButtonType
import com.example.challenge2.types.Routes


@Composable
fun ProductDetail(
    product: Product? = null,
    navController: NavController,
    cart: MutableList<Product>,
) {
    if (product == null) {
        navController.navigate(Routes.HOME.route)
    }

    val quantity = remember { mutableStateOf("1") }

    val isInCart = cart.contains(product)
    val addToCart = {
        if (!isInCart && product != null) {
            cart.add(product)
        }
    }

    val sizeOptions = listOf("36", "37", "38", "39", "40", "41", "42", "43")

    Column (
        modifier = Modifier.padding(32.dp).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(stringResource(R.string.pd_select_size), fontSize = 24.sp, lineHeight = 28.sp)
            MySelect(sizeOptions)

            Text(stringResource(R.string.pd_count_of_producy), fontSize = 24.sp, lineHeight = 28.sp)
            MyInput(
                value = quantity.value,
                onValueChange = { input ->
                    if (input.all { it.isDigit() }) {
                        quantity.value = input
                    }
                },
                label ="",
                placeholder = "",
            )
        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MyButton(
                onClick = {navController.popBackStack()},
                text = stringResource(R.string.p_back),
                type = ButtonType.SECONDARY
            )

            MyButton(
                onClick = {addToCart},
                text = stringResource(R.string.p_add_to_cart),
            )
        }
    }
}