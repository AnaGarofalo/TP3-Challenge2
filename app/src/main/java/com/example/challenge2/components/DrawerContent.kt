package com.example.challenge2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.challenge2.R
import com.example.challenge2.types.Routes
import com.example.challenge2.ui.theme.DarkBrown
import com.example.challenge2.ui.theme.DrawerBackground
import kotlinx.coroutines.CoroutineScope

@Composable
fun DrawerContent(scope: CoroutineScope, drawerState: DrawerState, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxHeight()
            .background(DrawerBackground)
            .padding(16.dp)
    ) {
        Text(
            stringResource(R.string.app_name),
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            lineHeight = 32.sp,
            color = DarkBrown
        )

        DrawerItem(
            R.string.nb_home,
            Routes.HOME, navController,
            painterResource(R.drawable.shop),
            scope,
            drawerState
        )

        DrawerItem(
            R.string.nb_favourites,
            Routes.FAVOURITES, navController,
            rememberVectorPainter(Icons.Outlined.FavoriteBorder),
            scope,
            drawerState
        )

        DrawerItem(
            R.string.nb_profile,
            Routes.PROFILE,
            navController,
            painterResource(R.drawable.user),
            scope,
            drawerState
        )

        DrawerItem(
            R.string.nb_settings,
            Routes.SETTINGS,
            navController,
            rememberVectorPainter(Icons.Outlined.Settings),
            scope,
            drawerState
        )
    }
}