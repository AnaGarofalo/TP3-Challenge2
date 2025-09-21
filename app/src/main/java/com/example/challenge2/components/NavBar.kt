package com.example.challenge2.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.challenge2.R
import com.example.challenge2.types.Routes

@Composable
fun NavBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = {navController.navigate(Routes.HOME.route) },
            icon = { Icon(Icons.Default.Home, contentDescription = stringResource(R.string.nb_home)) },
            label = { Text(stringResource(R.string.nb_home)) }
        )
        NavigationBarItem(
            selected = false,
            onClick = {  navController.navigate(Routes.PROFILE.route) },
            icon = { Icon(Icons.Default.Person, contentDescription = stringResource(R.string.nb_profile)) },
            label = { Text(stringResource(R.string.nb_profile)) }
        )

        NavigationBarItem(
            selected = false,
            onClick = {  navController.navigate(Routes.FAVOURITES.route) },
            icon = { Icon(Icons.Default.Favorite, contentDescription = stringResource(R.string.nb_favourites)) },
            label = { Text(stringResource(R.string.nb_favourites)) }
        )

        NavigationBarItem(
            selected = false,
            onClick = {  navController.navigate(Routes.SETTINGS.route) },
            icon = { Icon(Icons.Default.Settings, contentDescription = stringResource(R.string.nb_settings)) },
            label = { Text(stringResource(R.string.nb_settings)) }
        )
    }
}