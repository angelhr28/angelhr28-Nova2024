package com.angelhr28.novachallengeapp.ui.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.angelhr28.novachallengeapp.R
import com.angelhr28.novachallengeapp.data.model.User
import com.angelhr28.novachallengeapp.ui.component.LoadingComponent
import com.angelhr28.novachallengeapp.ui.feature.home.HomeViewModel
import com.angelhr28.novachallengeapp.ui.feature.home.UiEvent
import com.angelhr28.novachallengeapp.ui.feature.home.UiState

@Composable
fun ProfileScreen(
    uiState: UiState, viewModel: HomeViewModel
) {

    LaunchedEffect(key1 = true) {
        // Cargar Usuario al iniciar
        viewModel.handleUiEvent(UiEvent.User)
    }

    when {
        uiState.isLoading -> LoadingComponent(modifier = Modifier.fillMaxSize())
        else -> uiState.user?.let { ScreenContent(it) }
    }

}

@Composable
fun ScreenContent(user: User) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(72.dp))
        ProfileHeader()
        Spacer(modifier = Modifier.height(32.dp))
        ProfileDetails(user)
    }
}

@Composable
fun ProfileHeader() {
    Box(
        modifier = Modifier
            .size(120.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Profile Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileDetails(user: User) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Hola", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(user.userName, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(user.email, style = MaterialTheme.typography.bodyMedium)
    }
}