package com.angelhr28.novachallengeapp.ui.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelhr28.novachallengeapp.domain.usecase.getuser.GetUserUseCase
import com.angelhr28.novachallengeapp.domain.usecase.logout.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun handleUiEvent(uiEvent: UiEvent) = viewModelScope.launch {
        when (uiEvent) {
            is UiEvent.Logout -> logout()
            is UiEvent.User -> getUser()
        }
    }

    private suspend fun getUser() {
        try {
            _uiState.update { it.copy(isLoading = true) }
            getUserUseCase.invoke().collect { user ->
                _uiState.update { it.copy(isLoading = false, user = user) }
            }
        } catch (throwable: Throwable) {
            _uiState.update { it.copy(error = throwable) }
        }
    }

    private suspend fun logout() {
        try {
            logoutUseCase.invoke()
            _uiState.update { it.copy(goToLogin = true) }
        } catch (throwable: Throwable) {
            _uiState.update { it.copy(error = throwable) }
        }
    }

}