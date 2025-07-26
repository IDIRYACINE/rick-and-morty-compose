package com.idir.rickandmorty.features.details.hooks

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewModelScope
import com.idir.rickandmorty.features.details.state.CharacterDetailViewModel
import com.idir.rickandmorty.services.ServiceGateway
import kotlinx.coroutines.launch


@Composable
fun CharacterDetailsLoader(viewModel: CharacterDetailViewModel, id: Int) {

    LaunchedEffect(id) {
        viewModel.viewModelScope.launch {
            val result = ServiceGateway.instance
                .getCharactersService()
                .getCharacter(id)

            viewModel.update(result)
        }

    }
}