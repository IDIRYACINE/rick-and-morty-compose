package com.idir.rickandmorty.ui.components.buttons.previews

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idir.rickandmorty.ui.components.buttons.ButtonText
import com.idir.rickandmorty.ui.components.buttons.params.ButtonParams

@Preview(showBackground = true)
@Composable
fun ButtonTextPreview() {
    val params = ButtonParams(
        onClick = {},
        enabled = true,
        modifier = Modifier
            .padding(8.dp)
            .height(48.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors()
    )

    ButtonText(
        text = "Text Button",
        params = params
    )
}
