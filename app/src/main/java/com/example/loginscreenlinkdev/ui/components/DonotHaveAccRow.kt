package com.example.loginscreenlinkdev.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.loginscreenlinkdev.R

@Composable
fun DonotHaveAccRow(
    onSignUpClick: () -> Unit = {}
) {
    Row {
        Text(
            text = stringResource(R.string.don_t_have_an_account),
            fontSize = dimensionResource(R.dimen.font_small).value.sp
        )
        Text(
            text = stringResource(R.string.sign_up),
            color = colorResource(R.color.app_yellow),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable { onSignUpClick() },
            fontSize = 14.sp
        )
    }
}

