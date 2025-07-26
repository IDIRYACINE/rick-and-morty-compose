package com.idir.rickandmorty.features.details.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.idir.rickandmorty.core.entity.RickAndMortyCharacter


class CharacterDetailViewModel: ViewModel(){
    val character: MutableState<RickAndMortyCharacter?> = mutableStateOf(null)


    fun update(newCharacter: RickAndMortyCharacter?){
        character.value = newCharacter
    }

}