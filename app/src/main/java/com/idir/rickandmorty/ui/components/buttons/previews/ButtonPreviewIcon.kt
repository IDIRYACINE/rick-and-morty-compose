package com.idir.rickandmorty.ui.components.buttons.previews

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idir.rickandmorty.ui.components.buttons.ButtonIcon
import com.idir.rickandmorty.ui.components.buttons.params.ButtonParams

@Preview(showBackground = true)
@Composable
fun ButtonIconPreview() {
    val params = ButtonParams(
        onClick = {},
        enabled = true,
        modifier = Modifier
            .padding(8.dp)
            .height(48.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors()
    )

    ButtonIcon(
        icon = Icons.Default.Star, contentDescription = "Star", params = params
    )
}
