package com.example.loginscreenlinkdev.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.loginscreenlinkdev.R

@Composable
fun HeaderBackgroundBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.group1),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
                .width(dimensionResource(R.dimen.width))
                .height(dimensionResource(R.dimen.height))
        )

        Image(
            painter = painterResource(id = R.drawable.rectangle5),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(400.dp)
        )

        TopStartIcon(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.top_icon_padding))
                .size(dimensionResource(R.dimen.top_icon_size))
        )

        TopEndIcon(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.top_icon_padding))
                .size(dimensionResource(R.dimen.top_end_icon_size))
        )

        content()
    }
}

