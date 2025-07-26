package com.idir.rickandmorty.features.details.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idir.rickandmorty.core.entity.RickAndMortyCharacter
import com.idir.rickandmorty.services.ServiceGateway
import kotlinx.coroutines.launch


class CharacterDetailViewModel : ViewModel() {
    val character: MutableState<RickAndMortyCharacter?> = mutableStateOf(null)


    fun update(newCharacter: RickAndMortyCharacter?) {
        character.value = newCharacter
    }

    fun loadCharacter(id: Int) {
        viewModelScope.launch {
            val result = ServiceGateway.instance
                .getCharactersService()
                .getCharacter(id)

            update(result)
        }
    }

}