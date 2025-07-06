package com.example.loginscreenlinkdev


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.loginscreenlinkdev.ui.screens.LoginScreen
import com.example.loginscreenlinkdev.ui.screens.SignUp
import com.example.loginscreenlinkdev.viewModel.LoginViewModel

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object SignUp : Screen("signup")
}

@Composable
fun AppNavigation(navController: NavHostController, viewModel: LoginViewModel) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(viewModel = viewModel, navController = navController)
        }
        composable(Screen.SignUp.route) {
            SignUp(viewModel = viewModel, navController = navController)
        }
    }
}

