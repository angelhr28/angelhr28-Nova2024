package com.angelhr28.novachallengeapp.ui.feature.home

sealed class UiEvent {
    data object Logout : UiEvent()

    data object User : UiEvent()
}