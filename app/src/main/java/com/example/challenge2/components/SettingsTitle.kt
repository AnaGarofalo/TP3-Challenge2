package com.example.challenge2.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.challenge2.R

@Composable
fun SettingsTitle(textId: Int, color: Color) {
    Text(
        text = stringResource(textId),
        color = color,
        fontSize = 18.sp
    )
}