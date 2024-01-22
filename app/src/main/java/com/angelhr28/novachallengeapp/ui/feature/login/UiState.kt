package com.angelhr28.novachallengeapp.ui.feature.login

data class UiState(
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    var email: String = "",
    var userName: String = "",
    var goToHome: Boolean? = null
)