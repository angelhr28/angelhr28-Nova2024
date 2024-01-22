package com.angelhr28.novachallengeapp.ui.feature

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angelhr28.novachallengeapp.ui.feature.home.UiEvent
import com.angelhr28.novachallengeapp.ui.main.Destination
import kotlinx.coroutines.Job

@Composable
fun LogoutScreenContent(
    navController: NavHostController,
    sendUiEvent: (UiEvent) -> Job
) {
    BackHandler(enabled = true) {
        navController.popBackStack()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Cerrar Sesión", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("¿Estás seguro de que deseas cerrar sesión?")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                sendUiEvent(UiEvent.Logout)
                navController.navigate(Destination.Login.route)
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Cerrar Sesión")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Cerrar Sesión")
        }
    }
}