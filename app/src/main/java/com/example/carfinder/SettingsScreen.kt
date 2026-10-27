package com.example.carfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carfinder.ui.theme.CarFinderTheme


class SettingsScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isDark by ThemeManager.isDarkMode.collectAsState()
            CarFinderTheme(darkTheme = isDark) {
                var notifications by remember { mutableStateOf(true) }

                SettingsScreenCode(
                    darkModeEnabled = isDark,
                    onDarkModeChanged = { ThemeManager.setDarkMode(it) },
                    notificationsEnabled = notifications,
                    onNotificationsChanged = { notifications = it }
                )
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreenCode(
    darkModeEnabled: Boolean,
    onDarkModeChanged: (Boolean) -> Unit,
    notificationsEnabled: Boolean,
    onNotificationsChanged: (Boolean) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Configurações") },
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Preferências",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Ativar Notificações")
                    Switch(
                        checked = notificationsEnabled,
                        onCheckedChange = onNotificationsChanged,
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Modo Noturno")
                    Switch(
                        checked = darkModeEnabled,
                        onCheckedChange = onDarkModeChanged,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview(){
    CarFinderTheme {
        var darkMode by remember { mutableStateOf(false) }
        var notifications by remember { mutableStateOf(true) }
        SettingsScreenCode(
            darkModeEnabled = darkMode,
            onDarkModeChanged = { darkMode = it },
            notificationsEnabled = notifications,
            onNotificationsChanged = { notifications = it }
        )
    }
}