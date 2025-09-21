package com.example.challenge2.components
import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.challenge2.types.ButtonType

@Composable
fun MyModal(
    open: Boolean,
    close: () -> Unit,
    title: Int,
    confirmButtonText: Int,
    confirmAction: () -> Unit,
    cancelButtonText: Int,
    content: @Composable () -> Unit,
    icon: @Composable (() -> Unit)? = null,
    centerTitle: Boolean = true
) {
    if (open) {
        AlertDialog(
            onDismissRequest = {  close },
            title = { Text(stringResource(title), fontSize = 24.sp, lineHeight = 32.sp, modifier = Modifier.fillMaxWidth(), textAlign = if (centerTitle) TextAlign.Center else TextAlign.Left) },
            icon = icon,
            text = { content() },
            confirmButton = {
                MyButton(onClick = confirmAction, text = stringResource(confirmButtonText), type = ButtonType.TEXT)
            },
            dismissButton = {
                MyButton(onClick = close, text = stringResource(cancelButtonText), type = ButtonType.TEXT)
            }
        )
    }
}