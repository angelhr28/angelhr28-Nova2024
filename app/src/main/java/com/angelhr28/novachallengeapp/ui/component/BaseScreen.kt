package com.angelhr28.novachallengeapp.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.angelhr28.novachallengeapp.ui.theme.NovaChallengeAppTheme

@Composable
fun BaseScreen(content: @Composable () -> Unit) {
    NovaChallengeAppTheme {
        val surfaceModifier = Modifier.fillMaxSize()
        Surface(modifier = surfaceModifier) {
            content()
        }
    }
}
