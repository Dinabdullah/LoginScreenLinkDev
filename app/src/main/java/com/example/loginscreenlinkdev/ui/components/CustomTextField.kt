package com.example.loginscreenlinkdev.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import com.example.loginscreenlinkdev.R

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    labelResId: Int,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,

) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(labelResId), color = colorResource(R.color.app_yellow)) },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        modifier = modifier.padding(vertical = dimensionResource(R.dimen.field_padding_vertical), horizontal = dimensionResource(R.dimen.screen_padding)),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            focusedIndicatorColor = colorResource(R.color.app_yellow),
            unfocusedIndicatorColor = colorResource(R.color.app_yellow),
            focusedLabelColor = colorResource(R.color.app_yellow),
        )
    )
}