package com.idir.rickandmorty.ui.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.idir.rickandmorty.ui.components.buttons.params.ButtonParams

@Composable
fun ButtonIcon(
    icon: ImageVector,
    contentDescription: String?,
    params: ButtonParams
) {
    Button(
        onClick = params.onClick,
        enabled = params.enabled,
        shape = params.shape,
        colors = params.colors,
        modifier = params.modifier
    ) {
        Icon(icon, contentDescription)
    }
}
