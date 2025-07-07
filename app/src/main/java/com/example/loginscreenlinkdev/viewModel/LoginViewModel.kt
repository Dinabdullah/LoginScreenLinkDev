package com.example.loginscreenlinkdev.viewModel

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val rememberMe = mutableStateOf(false)

    val emailError = mutableStateOf<String?>(null)
    val passwordError = mutableStateOf<String?>(null)

    fun validateEmail(): Boolean {
        return email.value.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email.value).matches()
    }

    fun validatePassword(): Boolean {
        return password.value.length >= 6
    }

    fun onLoginClick(): Boolean {
        val isEmailValid = validateEmail().also {
            emailError.value = if (!it) {
                if (email.value.isBlank()) "Email is required"
                else "Invalid email format"
            } else null
        }

        val isPasswordValid = validatePassword().also {
            passwordError.value = if (!it) {
                if (password.value.isBlank()) "Password is required"
                else "Password must be at least 6 characters"
            } else null
        }

        return isEmailValid && isPasswordValid
    }

}

