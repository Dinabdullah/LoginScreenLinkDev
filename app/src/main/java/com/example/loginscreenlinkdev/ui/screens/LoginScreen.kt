package com.example.loginscreenlinkdev.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginscreenlinkdev.viewModel.LoginViewModel
import com.example.loginscreenlinkdev.R
import com.example.loginscreenlinkdev.ui.components.CustomButton
import com.example.loginscreenlinkdev.ui.components.CustomTextField
import com.example.loginscreenlinkdev.ui.components.DonotHaveAccRow
import com.example.loginscreenlinkdev.ui.components.RememberMeRow
import com.example.loginscreenlinkdev.ui.components.TopEndIcon
import com.example.loginscreenlinkdev.ui.components.TopStartIcon
import com.example.loginscreenlinkdev.ui.theme.LoginScreenLinkDevTheme


@Composable
fun LoginScreen(modifier: Modifier = Modifier, viewModel: LoginViewModel) {
    val email = viewModel.email
    val password = viewModel.password
    val rememberMe = viewModel.rememberMe
    val passwordVisible = remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.group1),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
                .width(356.dp)
                .height(386.dp)
        )
        TopStartIcon()
        TopEndIcon()

        Image(
            painter = painterResource(id = R.drawable.rectangle5),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(400.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.screen_padding)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dimensionResource(R.dimen.login_text_start_padding),
                        top = dimensionResource(R.dimen.login_top_padding)
                    ),
                text = stringResource(R.string.login),
                fontWeight = FontWeight.Black,
                fontSize = dimensionResource(R.dimen.font_header).value.sp,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.field_padding_vertical)))

            CustomTextField(
                value = email.value,
                onValueChange = { email.value = it },
                labelResId = R.string.email,
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.email),
                        modifier = Modifier.size(dimensionResource(R.dimen.icon_size)),
                        contentDescription = null,
                        tint = colorResource(R.color.app_yellow)
                    )
                }
            )

            if (viewModel.emailError.value != null) {
                Text(
                    text = viewModel.emailError.value!!,
                    color = colorResource(R.color.text_error),
                    fontSize = dimensionResource(R.dimen.font_small).value.sp,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.Start)
                )
            }

            CustomTextField(
                value = password.value,
                onValueChange = { password.value = it },
                labelResId = R.string.password,
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.pass),
                        contentDescription = null,
                        modifier = Modifier.size(dimensionResource(R.dimen.icon_size)),

                        tint = colorResource(R.color.app_yellow)
                    )
                },
                trailingIcon = {
                    val icon =
                        if (passwordVisible.value) R.drawable.baseline_remove_red_eye_24 else R.drawable.el_eye_close
                    IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = null,
                            modifier = Modifier.size(dimensionResource(R.dimen.icon_size))
                        )
                    }
                },
                visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
            )

            if (viewModel.passwordError.value != null) {
                Text(
                    text = viewModel.passwordError.value!!,
                    color = colorResource(R.color.text_error),
                    fontSize = dimensionResource(R.dimen.font_small).value.sp,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.Start)
                )
            }

            RememberMeRow(rememberMe = rememberMe)

            CustomButton(
                text = stringResource(R.string.login_capital),
                onClick = { viewModel.onLoginClick() }
            )

            DonotHaveAccRow(
                onSignUpClick = {

                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreenLinkDevTheme {
        LoginScreen(viewModel = LoginViewModel())
    }
}