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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.loginscreenlinkdev.R
import com.example.loginscreenlinkdev.Screen
import com.example.loginscreenlinkdev.ui.components.CustomButton
import com.example.loginscreenlinkdev.ui.components.CustomTextField
import com.example.loginscreenlinkdev.ui.components.DonotHaveAccRow
import com.example.loginscreenlinkdev.ui.components.RememberMeRow
import com.example.loginscreenlinkdev.ui.components.TopEndIcon
import com.example.loginscreenlinkdev.ui.components.TopStartIcon
import com.example.loginscreenlinkdev.viewModel.LoginViewModel

@Composable
fun SignUp(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel,
    navController: NavHostController
) {
    val email = viewModel.email
    val name = viewModel.name
    val password = viewModel.password
    val conPassword = viewModel.conPassword
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

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
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
                text = stringResource(R.string.create_an_account),
                fontWeight = FontWeight.Black,
                fontSize = dimensionResource(R.dimen.font_body).value.sp,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.field_padding_vertical)))

            CustomTextField(
                value = name.value,
                onValueChange = { name.value = it },
                labelResId = R.string.name,
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.person),
                        modifier = Modifier.size(dimensionResource(R.dimen.icon_size)),
                        contentDescription = null,
                        tint = colorResource(R.color.app_yellow)
                    )
                }
            )

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


            CustomTextField(
                value = conPassword.value,
                onValueChange = { conPassword.value = it },
                labelResId = R.string.conpassword,
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
            if (viewModel.confirmPasswordError.value != null) {
                Text(
                    text = viewModel.confirmPasswordError.value!!,
                    color = colorResource(R.color.text_error),
                    fontSize = dimensionResource(R.dimen.font_small).value.sp,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.Start)
                )
            }




            RememberMeRow(rememberMe = rememberMe)

            CustomButton(
                text = stringResource(R.string._capital),
                onClick = { viewModel.onLoginClick() }
            )
            DonotHaveAccRow(
                firstText = stringResource(R.string.already_have_an_account),
                actionText = stringResource(R.string.login_small),
                onActionClick = {
                    navController.navigate(Screen.Login.route)
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    val navController = rememberNavController()
    SignUp(viewModel = LoginViewModel(), navController = navController)
}
