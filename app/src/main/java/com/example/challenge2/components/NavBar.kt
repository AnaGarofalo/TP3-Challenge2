package com.example.challenge2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.challenge2.R
import com.example.challenge2.types.Routes
import com.example.challenge2.ui.theme.PrimaryBrown

@Composable
fun NavBar(navController: NavHostController, openCartModal: () -> Unit) {
    Box(
        Modifier.fillMaxWidth().background(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 16.dp, start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            NavBarItem(
                painter = painterResource(R.drawable.user),
                labelText = R.string.nb_profile,
                route = Routes.PROFILE,
                navController = navController
            )
            NavBarItem(
                painter =rememberVectorPainter(Icons.Outlined.FavoriteBorder),
                labelText = R.string.nb_favourites,
                route = Routes.FAVOURITES,
                navController = navController
            )

            FloatingActionButton(
                onClick = {navController.navigate(Routes.HOME.route)},
                containerColor = PrimaryBrown,
                shape = CircleShape,
                modifier = Modifier
                    .offset(y = (-32).dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.shop),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            NavBarItem(
                painter = painterResource(R.drawable.bag),
                labelText = R.string.nb_cart,
                navController = navController,
                onClick = openCartModal,
            )

            NavBarItem(
                painter = rememberVectorPainter(Icons.Outlined.Settings),
                labelText = R.string.nb_settings,
                route = Routes.SETTINGS,
                navController = navController
            )
        }
    }
}