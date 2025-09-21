package com.example.challenge2.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.challenge2.R
import com.example.challenge2.data.Product
import com.example.challenge2.data.sampleProducts
import com.example.challenge2.types.Routes
import com.example.challenge2.ui.theme.DarkBrown
import com.example.challenge2.ui.theme.ModalIconColor

@Composable
fun Cart(cartItems: List<Product>, open: Boolean, close: () -> Unit, navController: NavController) {
    val confirmAction = {
        close()
        navController.navigate(Routes.HOME.route)
    }

    MyModal(
        open = open,
        close = close,
        confirmAction = confirmAction,
        cancelButtonText = R.string.p_back,
        confirmButtonText = R.string.p_buy,
        title = R.string.cm_title,
        centerTitle = false,
        content = {
            Column {
                Text( stringResource(R.string.cm_content), color = DarkBrown)
                LazyColumn (modifier = Modifier.padding(16.dp)) {
                    items(cartItems) { product ->
                        CartItem(
                            product = product,
                            index = cartItems.indexOf(product) + 1,
                        )
                    }
                }
            }
        },
    )
}