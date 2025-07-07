package com.example.loginscreenlinkdev.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.loginscreenlinkdev.R

@Composable
fun TopStartIcon(
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.group),
            contentDescription = null,
            modifier = modifier.align(Alignment.TopStart)
        )
    }
}

@Composable
fun TopEndIcon(
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.vector),
            contentDescription = null,
            modifier = modifier.align(Alignment.TopEnd)
        )
    }
}
