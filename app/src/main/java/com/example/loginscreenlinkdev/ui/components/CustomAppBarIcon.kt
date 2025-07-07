package com.example.loginscreenlinkdev.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.example.loginscreenlinkdev.R

@Composable
fun TopStartIcon(
    padding: Dp = dimensionResource(R.dimen.top_icon_padding),
    size: Dp = dimensionResource(R.dimen.top_icon_size)

) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.group),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)


                .padding(padding)
                .size(size)
        )
    }
}

@Composable
fun TopEndIcon(
    padding: Dp = dimensionResource(R.dimen.top_icon_padding),
    size: Dp = dimensionResource(R.dimen.top_end_icon_size)
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.vector),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(padding)
                .size(size)
        )
    }
}
