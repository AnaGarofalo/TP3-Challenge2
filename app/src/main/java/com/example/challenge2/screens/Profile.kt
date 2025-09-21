package com.example.challenge2.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.challenge2.components.MyInput
import com.example.challenge2.R
import com.example.challenge2.components.ProfileCard
import com.example.challenge2.data.sampleUser

@Composable
fun Profile(){
    val email = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val website = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ProfileCard(user = sampleUser, onEditClick = {})
        MyInput(
            value = email.value,
            onValueChange = { email.value = it },
            label = stringResource(R.string.pr_email_label),
            placeholder = stringResource(R.string.pr_email_placeholder),
            icon = Icons.Outlined.Email
        )
        MyInput(
            value = phone.value,
            onValueChange = { phone.value = it },
            label = stringResource(R.string.pr_phone_label),
            placeholder = stringResource(R.string.pr_phone_placeholder),
            icon = Icons.Outlined.Phone
        )
        MyInput(
            value = website.value,
            onValueChange = { website.value = it },
            label = stringResource(R.string.pr_website_label),
            placeholder = stringResource(R.string.pr_website_placeholder),
            icon = Icons.Outlined.Settings
        )
        MyInput(
            value = password.value,
            onValueChange = { password.value = it },
            label = stringResource(R.string.pr_password_label),
            placeholder = stringResource(R.string.pr_password_placeholder),
            icon = Icons.Outlined.Lock
        )
    }
}