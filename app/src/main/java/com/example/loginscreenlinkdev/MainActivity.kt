package com.example.loginscreenlinkdev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginscreenlinkdev.ui.theme.LoginScreenLinkDevTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginScreenLinkDevTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    val loginViewModel: LoginViewModel = viewModel()
                    LoginScreen(
                        modifier = Modifier.padding(),
                        viewModel = loginViewModel
                    )
                }
            }
        }
    }
}

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

        Image(
            painter = painterResource(id = R.drawable.group),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(42.dp)
                .size(36.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.vector),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(42.dp)
                .size(30.dp)
        )

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
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 160.dp),
                text = "Login",
                fontWeight = FontWeight.Black,
                fontSize = 40.sp,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = modifier.height(12.dp))

            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Email", color = Color(0xFFF5BC33)) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email icon",
                        tint = Color(0xFFF5BC33)
                    )
                },
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .width(300.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedIndicatorColor = Color(0xFFF5BC33),
                    unfocusedIndicatorColor = Color(0xFFF5BC33),
                    focusedLabelColor = Color(0xFFF5BC33),
                )
            )
            if (viewModel.emailError.value != null) {
                Text(
                    text = viewModel.emailError.value!!,
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.Start)
                )
            }


            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Password", color = Color(0xFFF5BC33)) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password icon",
                        tint = Color(0xFFF5BC33)
                    )
                },
                trailingIcon = {
                    val icon = if (passwordVisible.value) R.drawable.baseline_remove_red_eye_24 else R.drawable.el_eye_close
                    IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = if (passwordVisible.value) "Hide password" else "Show password",
                            modifier = modifier.size(16.dp)
                        )
                    }
                },
                visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .width(300.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedIndicatorColor = Color(0xFFF5BC33),
                    unfocusedIndicatorColor = Color(0xFFF5BC33),
                    focusedLabelColor = Color(0xFFF5BC33),
                )
            )
            if (viewModel.passwordError.value != null) {
                Text(
                    text = viewModel.passwordError.value!!,
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.Start)
                )
            }





            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = rememberMe.value,
                        onCheckedChange = { rememberMe.value = it },
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color(0xFFFAE7B3),
                            checkedColor = Color(0xFFFAE7B3),
                        )
                    )
                    Text("Remember me", fontSize = 12.sp)
                }
                Text(
                    "Forget password?",
                    fontSize = 12.sp,
                )
            }


            Button(
                onClick = { viewModel.onLoginClick() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC122)),
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier
                    .padding(vertical = 24.dp)
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    "LOGIN",
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }


            Row {
                Text("Don’t have an account? ")
                Text(
                    text = "Sign Up",
                    color = Color(0xFFF5BC33),
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { }
                )
            }
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