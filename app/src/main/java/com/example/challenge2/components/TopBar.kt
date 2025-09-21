package com.example.challenge2.components

import androidx.compose.foundation.background
import com.example.challenge2.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.challenge2.types.Routes
import com.example.challenge2.ui.theme.CardBackground
import com.example.challenge2.ui.theme.DarkBrown

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String, navController: NavController, openDrawer: () -> Unit) {
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route

    CenterAlignedTopAppBar(
        title = { Text(title) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = CardBackground
        ),
        navigationIcon = {
            if (currentRoute.equals(Routes.PROFILE.route)) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                }
            } else {
                IconButton(onClick = { openDrawer() }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
            }
        },
        actions = {
            IconButton(onClick = { /* acción */ }) {
                Icon(
                    painterResource(id = R.drawable.trailing_icon),
                    contentDescription = null,
                    tint = DarkBrown
                )
            }
        }
    )
}