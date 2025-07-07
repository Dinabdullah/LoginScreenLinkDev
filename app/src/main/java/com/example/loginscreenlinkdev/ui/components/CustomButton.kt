package com.example.loginscreenlinkdev.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginscreenlinkdev.R

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button_yellow)),
        shape = RoundedCornerShape(dimensionResource(R.dimen.round_courner)),
        modifier = modifier
            .padding(vertical = dimensionResource(R.dimen.button_padding_vertical), horizontal = dimensionResource(R.dimen.screen_padding))
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.button_height))
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = dimensionResource(R.dimen.font_body).value.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
        )
    }
}