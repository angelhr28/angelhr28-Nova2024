package com.angelhr28.novachallengeapp.ui.entity

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class ScreenNavigation(val title: String, val icon: ImageVector) {
    ProfileScreen("Perfil", Icons.Filled.Person),
    ShapesScreen("Figuras Geométricas", Icons.Filled.Create),
    LogoutScreen("Cerrar Sesión", Icons.Filled.Close)
}