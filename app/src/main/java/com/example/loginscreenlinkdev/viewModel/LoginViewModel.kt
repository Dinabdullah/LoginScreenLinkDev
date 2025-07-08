package com.example.loginscreenlinkdev.viewModel

import android.content.Context
import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.loginscreenlinkdev.R

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

    fun onLoginClick(context: Context): Boolean {
        val isEmailValid = validateEmail().also {
            emailError.value = if (!it) {
                if (email.value.isBlank()) context.getString(R.string.error_email_required)
                else context.getString(R.string.error_email_invalid)
            } else null
        }

        val isPasswordValid = validatePassword().also {
            passwordError.value = if (!it) {
                if (password.value.isBlank()) context.getString(R.string.error_password_required)
                else context.getString(R.string.error_password_short)
            } else null
        }

        return isEmailValid && isPasswordValid
    }


}

