package com.idir.rickandmorty.features.details.hooks

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.idir.rickandmorty.features.details.state.CharacterDetailViewModel


@Composable
fun CharacterDetailsLoader(viewModel: CharacterDetailViewModel, id: Int) {

    LaunchedEffect(id) {
        viewModel.loadCharacter(id)

    }
}