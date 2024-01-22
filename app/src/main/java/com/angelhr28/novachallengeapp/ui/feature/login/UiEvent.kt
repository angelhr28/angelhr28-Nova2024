package com.angelhr28.novachallengeapp.ui.feature.login

sealed class UiEvent {
    class UserName(val userName: String) : UiEvent()
    class Email(val email: String) : UiEvent()
    data object Login : UiEvent()
}