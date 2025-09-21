package com.example.challenge2.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.challenge2.types.Routes
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.challenge2.ui.theme.PrimaryBrown
import com.example.challenge2.ui.theme.UnselectedNavBarItem


@Composable
fun NavBarItem(
    onClick: (() -> Unit)? = null,
    painter: Painter,
    labelText: Int,
    route: Routes? = null,
    navController: NavController,
){
    val isSelected = if (route == null) false else navController.currentBackStackEntryAsState().value?.destination?.route == route.route
    val color = if (isSelected) PrimaryBrown else UnselectedNavBarItem
    val clickAction = {
        if (onClick == null && route != null) {
            navController.navigate(route.route)
        } else if (onClick != null) onClick ()
    }
    Button(
        onClick = clickAction,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(0.dp),
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painter,
                tint = color,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(stringResource(labelText), color = color)
        }
    }
}

