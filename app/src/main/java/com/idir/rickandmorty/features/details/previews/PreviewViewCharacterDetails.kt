package com.idir.rickandmorty.features.details.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.idir.rickandmorty.features.details.view.ViewCharacterDetails
import com.idir.rickandmorty.features.details.view.ViewCharacterDetailsParams

@Preview
@Composable
fun PreviewViewCharacterDetails() {

    ViewCharacterDetails(ViewCharacterDetailsParams())
}