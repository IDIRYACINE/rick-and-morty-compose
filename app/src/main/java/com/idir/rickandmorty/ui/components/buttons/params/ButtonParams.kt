package com.idir.rickandmorty.ui.components.buttons.params
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class ButtonParams(
    val onClick: () -> Unit,
    val enabled: Boolean = true,
    val shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    val colors: ButtonColors  ,
    val modifier: Modifier = Modifier
)