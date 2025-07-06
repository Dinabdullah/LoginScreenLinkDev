package com.example.loginscreenlinkdev.ui.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.loginscreenlinkdev.R

@Composable
fun RememberMeRow(rememberMe: MutableState<Boolean>) {
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
                    uncheckedColor = colorResource(R.color.app_yellow_light),
                    checkedColor = colorResource(R.color.app_yellow_light),
                )
            )
            Text(
                text = stringResource(R.string.remember_me),
                fontSize = dimensionResource(R.dimen.font_small).value.sp
            )
        }

        Text(
            text = stringResource(R.string.forget_password),
            fontSize = dimensionResource(R.dimen.font_small).value.sp
        )
    }
}
