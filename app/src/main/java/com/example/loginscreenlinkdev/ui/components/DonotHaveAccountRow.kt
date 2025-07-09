package com.example.loginscreenlinkdev.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.loginscreenlinkdev.R

@Composable
fun DonotHaveAccRow(
    labelText: String,
    actionText: String,
    onActionClick: () -> Unit
) {
    Row(modifier = Modifier.clickable { onActionClick() }) {
        Text(
            text = labelText,
            fontSize = dimensionResource(R.dimen.font_body).value.sp
        )
        Text(
            text = actionText,
            color = colorResource(R.color.app_yellow),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            fontSize = dimensionResource(R.dimen.font_body).value.sp
        )
    }
}


