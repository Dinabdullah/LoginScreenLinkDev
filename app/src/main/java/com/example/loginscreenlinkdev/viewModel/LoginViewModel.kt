package com.example.loginscreenlinkdev.viewModel

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val email = mutableStateOf("")
    val emailError = mutableStateOf<String?>(null)
    val password = mutableStateOf("")
    val passwordError = mutableStateOf<String?>(null)
    val rememberMe = mutableStateOf(false)

    fun onLoginClick() {

        val isEmailValid = validateEmail()
        val isPasswordValid = validatePassword()

        if (isEmailValid && isPasswordValid) {

        }
    }

    private fun validateEmail(): Boolean {
        return when {
            email.value.isBlank() -> {
                emailError.value = "Email is required"
                false
            }

            !Patterns.EMAIL_ADDRESS.matcher(email.value).matches() -> {
                emailError.value = "Invalid email format"
                false
            }

            else -> {
                emailError.value = null
                true
            }
        }
    }

    private fun validatePassword(): Boolean {
        return when {
            password.value.isBlank() -> {
                passwordError.value = "Password is required"
                false
            }

            password.value.length < 6 -> {
                passwordError.value = "Password must be at least 6 characters"
                false
            }

            else -> {
                passwordError.value = null
                true
            }
        }
    }

}