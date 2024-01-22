package com.angelhr28.novachallengeapp.ui.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelhr28.novachallengeapp.data.model.User
import com.angelhr28.novachallengeapp.domain.usecase.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val email: String
        get() = _uiState.value.email

    private val userName: String
        get() = _uiState.value.userName

    fun handleUiEvent(uiEvent: UiEvent) = viewModelScope.launch {
        when (uiEvent) {
            is UiEvent.Login -> registerUser()
            is UiEvent.Email -> setEmail(uiEvent.email)
            is UiEvent.UserName -> setUserName(uiEvent.userName)
        }
    }

    private fun setUserName(userName: String) {
        _uiState.update { it.copy(userName = userName) }
    }

    private fun setEmail(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    private suspend fun registerUser() {
        try {
            _uiState.update { it.copy(isLoading = true) }
            val user = User(email = email, userName = userName)
            loginUseCase.invoke(user)
            _uiState.update { it.copy(isLoading = false, goToHome = true) }
        } catch (throwable: Throwable) {
            _uiState.update { it.copy(isLoading = false, error = throwable) }
        }
    }

}