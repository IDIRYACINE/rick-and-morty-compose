package com.idir.rickandmorty.ui.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.idir.rickandmorty.ui.components.buttons.params.ButtonParams


@Composable
fun ButtonText(
    text: String,
    params: ButtonParams
) {
    Button(
        onClick = params.onClick,
        enabled = params.enabled,
        shape = params.shape,
        colors = params.colors,
        modifier = params.modifier
    ) {
        Text(text)
    }
}
