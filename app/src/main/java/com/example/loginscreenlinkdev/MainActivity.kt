package com.example.loginscreenlinkdev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.loginscreenlinkdev.ui.theme.LoginScreenLinkDevTheme
import com.example.loginscreenlinkdev.viewModel.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val loginViewModel: LoginViewModel = viewModel()

            LoginScreenLinkDevTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { _ ->
                    AppNavigation(
                        navController = navController,
                        viewModel = loginViewModel
                    )
                }
            }
        }
    }
}
