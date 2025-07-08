package com.example.loginscreenlinkdev.viewModel

import android.content.Context
import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.loginscreenlinkdev.R

class SignUpViewModel : ViewModel() {
    val name = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val conPassword = mutableStateOf("")
    val rememberMe = mutableStateOf(false)
    val emailError = mutableStateOf<String?>(null)
    val passwordError = mutableStateOf<String?>(null)
    val confirmPasswordError = mutableStateOf<String?>(null)

    fun onSignUpClick(context: Context): Boolean {
        val isEmailValid = validateEmail(context)
        val isPasswordValid = validatePassword(context)
        val isConfirmPasswordValid = validateConfirmPassword(context)
        return isEmailValid && isPasswordValid && isConfirmPasswordValid
    }

    private fun validateEmail(context: Context): Boolean {
        return when {
            email.value.isBlank() -> {
                emailError.value = context.getString(R.string.error_email_required)
                false
            }

            !Patterns.EMAIL_ADDRESS.matcher(email.value).matches() -> {
                emailError.value = context.getString(R.string.error_email_invalid)
                false
            }

            else -> {
                emailError.value = null
                true
            }
        }
    }

    private fun validatePassword(context: Context): Boolean {
        return when {
            password.value.isBlank() -> {
                passwordError.value = context.getString(R.string.error_password_required)
                false
            }

            password.value.length < 6 -> {
                passwordError.value = context.getString(R.string.error_password_short)
                false
            }

            else -> {
                passwordError.value = null
                true
            }
        }
    }

    private fun validateConfirmPassword(context: Context): Boolean {
        return when {
            conPassword.value.isBlank() -> {
                confirmPasswordError.value =
                    context.getString(R.string.error_confirm_password_required)
                false
            }

            conPassword.value != password.value -> {
                confirmPasswordError.value =
                    context.getString(R.string.error_passwords_do_not_match)
                false
            }

            else -> {
                confirmPasswordError.value = null
                true
            }
        }
    }
}
