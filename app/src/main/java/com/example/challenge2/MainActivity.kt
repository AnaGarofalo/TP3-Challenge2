package com.example.challenge2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.challenge2.components.NavBar
import com.example.challenge2.components.TopBar
import com.example.challenge2.screens.ItemList
import com.example.challenge2.types.Routes
import com.example.challenge2.types.routeTitles
import com.example.challenge2.ui.theme.Challenge2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Challenge2Theme {
                val navController = rememberNavController()
                val currentBackStack by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStack?.destination?.route

                Scaffold(
                    topBar = {
                        TopBar(
                            title = stringResource(routeTitles[currentRoute] ?: R.string.app_name),
                            navController = navController,
                        )
                    },
                    bottomBar = { NavBar(navController) }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Routes.HOME.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(route = Routes.HOME.route) { ItemList() }
                        composable(route = Routes.PROFILE.route) { Text(text = "Profile") }
                        composable(route = Routes.SETTINGS.route) { Text(text = "Settings") }
                        composable(route = Routes.FAVOURITES.route) { Text(text = "Favourite") }
                    }
                }
            }
        }
    }
}
