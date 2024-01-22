package com.angelhr28.novachallengeapp.ui.feature.home

import com.angelhr28.novachallengeapp.data.model.User

data class UiState(
    val user: User? = null,
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    var goToLogin: Boolean? = null
)