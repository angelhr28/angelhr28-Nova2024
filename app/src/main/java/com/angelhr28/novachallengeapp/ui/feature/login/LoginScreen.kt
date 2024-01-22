package com.angelhr28.novachallengeapp.ui.feature.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.angelhr28.novachallengeapp.ui.component.LoadingComponent
import com.angelhr28.novachallengeapp.ui.feature.ProfileHeader
import kotlinx.coroutines.Job


@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigateToHome: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    when {
        uiState.isLoading -> LoadingComponent(modifier = Modifier.fillMaxSize())
        else -> ScreenContent(uiState, viewModel::handleUiEvent)
    }

    uiState.goToHome?.let {
        onNavigateToHome()
    }

}

@Composable
fun ScreenContent(uiState: UiState, sendUiEvent: (UiEvent) -> Job) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var email by remember { mutableStateOf(uiState.email) }
        var userName by remember { mutableStateOf(uiState.userName) }

        var errorEmail by remember { mutableStateOf(true) }
        var errorUserName by remember { mutableStateOf(true) }

        Spacer(modifier = Modifier.height(72.dp))
        ProfileHeader()
        Spacer(modifier = Modifier.height(16.dp))
        Text("Bienvenido", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = userName,
            isError = errorUserName,
            onValueChange = {
                if (it.all { char -> char.isLetter() }) {
                    userName = it
                    errorUserName = !isValidUserName(userName)
                    sendUiEvent(UiEvent.UserName(userName))
                }
            },
            placeholder = { Text("Example: Angel") },
            label = { Text("UserName") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        TextField(
            isError = errorEmail,
            value = email,
            onValueChange = {
                email = it
                errorEmail = !isValidEmail(email)
                sendUiEvent(UiEvent.Email(email))
            },
            placeholder = { Text("Example: angelhuamannahui@gmail.com") },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )


        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                sendUiEvent(UiEvent.Login)
            },
            enabled = !errorEmail && !errorUserName,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Login")
        }
    }
}

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isValidUserName(userName: String): Boolean {
    return userName.length >= 3
}