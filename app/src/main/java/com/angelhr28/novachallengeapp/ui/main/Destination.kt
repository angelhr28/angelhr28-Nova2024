package com.angelhr28.novachallengeapp.ui.main

sealed class Destination(val route: String) {
    data object Login : Destination("login")

    data object Home : Destination("home")

}