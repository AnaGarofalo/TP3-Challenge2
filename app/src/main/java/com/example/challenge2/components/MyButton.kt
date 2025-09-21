package com.example.challenge2.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.types.ButtonType
import com.example.challenge2.ui.theme.PrimaryBrown

@Composable
fun MyButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    type: ButtonType = ButtonType.PRIMARY,
) {
    val containerColor = when (type) {
        ButtonType.PRIMARY -> PrimaryBrown
        ButtonType.SECONDARY -> Color.Transparent
        ButtonType.TEXT -> Color.Transparent
    }

    val textColor = when (type) {
        ButtonType.PRIMARY -> Color.White
        ButtonType.SECONDARY -> PrimaryBrown
        ButtonType.TEXT -> PrimaryBrown
    }

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(100.dp),
        border = if (ButtonType.TEXT != type) BorderStroke(1.dp, PrimaryBrown) else null, // ← así se hace en Material3
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor
        ),
        content = { Text(
            text = text,
            modifier = Modifier,
            fontSize = 14.sp,
            color = textColor
        ) }
    )
}