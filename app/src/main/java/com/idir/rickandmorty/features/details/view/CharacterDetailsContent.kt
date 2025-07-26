package com.idir.rickandmorty.features.details.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.idir.rickandmorty.R
import com.idir.rickandmorty.core.entity.RickAndMortyCharacter
import com.idir.rickandmorty.features.details.widgets.CharacterImage
import com.idir.rickandmorty.features.details.widgets.CharacterInformationSection


@Composable
fun CharacterDetailsContents(character: RickAndMortyCharacter) {
    Column(
        modifier = Modifier
            .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 64.dp)
            .verticalScroll(rememberScrollState())
    ) {
        CharacterImage(
            character.image
        )


        CharacterInformationSection(
            title = stringResource((R.string.name)),
            content = character.name
        )

        CharacterInformationSection(
            title = stringResource((R.string.species)),
            content = character.species
        )

        CharacterInformationSection(
            title = stringResource((R.string.gender)),
            content = character.gender
        )

        CharacterInformationSection(
            title = stringResource((R.string.status)),
            content = character.status
        )

        CharacterInformationSection(
            title = stringResource((R.string.type)),
            content = character.type.ifBlank { "Unknown" }
        )
    }
}