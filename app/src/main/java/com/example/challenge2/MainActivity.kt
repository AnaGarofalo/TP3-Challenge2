package com.example.challenge2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.challenge2.components.Cart
import com.example.challenge2.components.DrawerContent
import com.example.challenge2.components.NavBar
import com.example.challenge2.components.TopBar
import com.example.challenge2.data.Product
import com.example.challenge2.data.sampleProducts
import com.example.challenge2.screens.FavouritesScreen
import com.example.challenge2.screens.ItemList
import com.example.challenge2.screens.ProductDetail
import com.example.challenge2.screens.Profile
import com.example.challenge2.screens.SettingsScreen
import com.example.challenge2.types.Routes
import com.example.challenge2.types.routeTitles
import com.example.challenge2.ui.theme.Challenge2Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Challenge2Theme {
                val navController = rememberNavController()
                val currentBackStack by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStack?.destination?.route

                val favoriteProducts = remember { mutableStateListOf<Product>() }
                val cart = remember { mutableStateListOf<Product>() }
                val showCart = remember { mutableStateOf(false) }

                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        DrawerContent(scope, drawerState, navController)
                    }
                ) {
                    Scaffold(
                        topBar = {
                            TopBar(
                                title = stringResource(routeTitles[currentRoute] ?: R.string.app_name),
                                navController = navController,
                                openDrawer = {
                                    scope.launch { drawerState.open() } // abrir drawer al tocar hamburguesa
                                }
                            )
                        },
                        bottomBar = { NavBar(navController, openCartModal = { showCart.value = true }) }
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = Routes.HOME.route,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable(route = Routes.HOME.route) { ItemList(favoriteProducts, navController) }
                            composable(route = Routes.PROFILE.route) { Profile() }
                            composable(route = Routes.SETTINGS.route) { SettingsScreen(navController) }
                            composable(route = Routes.FAVOURITES.route) { FavouritesScreen(favoriteProducts) }
                            composable(
                                route = "product/{productId}",
                                arguments = listOf(navArgument("productId") { type = NavType.IntType })
                            ) { backStackEntry ->
                                val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                                val product = sampleProducts.find { it.id == productId }
                                ProductDetail(product, navController, cart, openCartModal = { showCart.value = true })
                            }
                        }

                        Cart(cart, showCart.value, { showCart.value = false }, navController)
                    }
                }
            }
        }
    }
}
