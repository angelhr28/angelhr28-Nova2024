package com.angelhr28.novachallengeapp.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.angelhr28.novachallengeapp.ui.feature.home.HomeScreen
import com.angelhr28.novachallengeapp.ui.feature.login.LoginScreen

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "login") {
        composable(Destination.Login.route) {
            LoginScreen(
                onNavigateToHome = {
                    navController.navigate(
                        Destination.Home.route,
                        navOptions { launchSingleTop = true }
                    )
                }
            )

        }

        composable(Destination.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}