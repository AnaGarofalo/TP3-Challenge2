package com.example.challenge2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.challenge2.types.Routes
import com.example.challenge2.ui.theme.DrawerItemColor
import com.example.challenge2.ui.theme.SelectedDrawerColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerItem(title: Int, route: Routes, navController: NavController, painter: Painter, scope: CoroutineScope, drawerState: DrawerState,) {
    val isSelected = navController.currentBackStackEntryAsState().value?.destination?.route == route.route

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (isSelected) SelectedDrawerColor else Color.Transparent, shape = RoundedCornerShape(120.dp))
            .clickable {
                navController.navigate(route.route)
                scope.launch { drawerState.close() }
            }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            tint = DrawerItemColor,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            stringResource(title),
            fontWeight = FontWeight.Bold,
            color = DrawerItemColor
        )
    }
}