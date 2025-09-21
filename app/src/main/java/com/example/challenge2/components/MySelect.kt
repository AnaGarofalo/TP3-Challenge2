package com.example.challenge2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.challenge2.ui.theme.SecondaryBrown

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySelect(options: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedSize by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            value = selectedSize,
            onValueChange = {},
            readOnly = true,
            label = null,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
            modifier = Modifier.menuAnchor()
                .background(Color.Transparent, shape = RoundedCornerShape(4.dp))
                .border(1.dp, SecondaryBrown, RoundedCornerShape(4.dp)),
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTrailingIconColor  = SecondaryBrown,
                unfocusedTrailingIconColor  = SecondaryBrown,
                focusedLabelColor = SecondaryBrown,
                unfocusedLabelColor = SecondaryBrown,
                cursorColor = SecondaryBrown,
            ),
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { size ->
                DropdownMenuItem(
                    text = { Text(size) },
                    onClick = {
                        selectedSize = size
                        expanded = false
                    }
                )
            }
        }
    }
}