package com.example.challenge2.types

import com.example.challenge2.R

enum class Routes(val route: String) {
    HOME("home"),
    FAVOURITES("favourites"),
    PROFILE("profile"),
    SETTINGS("settings"),
    PRODUCT("product/")
}

val routeTitles = mapOf(
    Routes.HOME.route to R.string.tbt_shop_list,
    Routes.FAVOURITES.route to R.string.tbt_favourites,
    Routes.PROFILE.route to R.string.tbt_profile,
    Routes.SETTINGS.route to R.string.tbt_settings,
)
