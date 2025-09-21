package com.example.challenge2.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.challenge2.R
import com.example.challenge2.components.SettingsTitle
import com.example.challenge2.components.SettingsTitleWithArrow
import com.example.challenge2.components.SettingsTitleWithSwitch
import com.example.challenge2.types.Routes

@Composable
fun SettingsScreen(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxWidth().padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        SettingsTitle(textId = R.string.st_account_settings, color = Color(0xFFADADAD))
        SettingsTitleWithArrow(textId = R.string.st_edit_profile, onClick = {
            navController.navigate(Routes.PROFILE.route)
        })
        SettingsTitleWithArrow(textId = R.string.st_change_password)
        SettingsTitleWithSwitch(textId = R.string.st_push_notifications)
        SettingsTitleWithSwitch(textId = R.string.st_dark_mode)

        Divider(
            color = Color(0xFFADADAD),
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        SettingsTitle(textId = R.string.st_more, color = Color(0xFFADADAD))
        SettingsTitleWithArrow(textId = R.string.st_about_us)
        SettingsTitleWithArrow(textId = R.string.st_privacy_policy)
        SettingsTitleWithArrow(textId = R.string.st_terms_of_service)
    }
}