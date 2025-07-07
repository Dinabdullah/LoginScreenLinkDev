package com.example.loginscreenlinkdev.viewModel

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    val name = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val conPassword = mutableStateOf("")
    val rememberMe = mutableStateOf(false)

    val emailError = mutableStateOf<String?>(null)
    val passwordError = mutableStateOf<String?>(null)
    val confirmPasswordError = mutableStateOf<String?>(null)

    fun onSignUpClick(): Boolean {
        val isEmailValid = validateEmail()
        val isPasswordValid = validatePassword()
        val isConfirmPasswordValid = validateConfirmPassword()
        return isEmailValid && isPasswordValid && isConfirmPasswordValid
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

    private fun validateConfirmPassword(): Boolean {
        return when {
            conPassword.value.isBlank() -> {
                confirmPasswordError.value = "Confirm password is required"
                false
            }

            conPassword.value != password.value -> {
                confirmPasswordError.value = "Passwords do not match"
                false
            }

            else -> {
                confirmPasswordError.value = null
                true
            }
        }
    }
}